package zl.readCloud.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author coffee
 * @Description: 配置类实现AsyncConfigurer接口，并重写getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor，
 * 这样我们就获得一个基于线程池TaskExecutor
 *
 */
@Configuration
@ComponentScan("zl.readCloud.service") //必须加此注解扫描包
@EnableAsync( proxyTargetClass = true)//利用@EnableAsync注解开启异步任务支持
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        taskExecutor.setCorePoolSize(3);
        //设置最大线程数
        taskExecutor.setMaxPoolSize(10);
        //线程池所使用的缓冲队列容量
        taskExecutor.setQueueCapacity(20);
        //等待任务在关机时完成--表明等待所有线程执行完
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        taskExecutor.setAwaitTerminationSeconds(5);
        //  线程名称前缀
        taskExecutor.setThreadNamePrefix("my-Executor-");
        // 拒绝策略   由调用线程处理该任务
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化线程
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}