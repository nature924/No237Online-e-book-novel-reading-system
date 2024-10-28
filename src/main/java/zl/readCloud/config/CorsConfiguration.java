package zl.readCloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 允许跨域
 */
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        // 允许跨域访问资源定义： / 所有资源
        corsRegistry.addMapping("/**")
                //只允许本地的8001端口访.allowedOrigins("http://localhost:8001", "http://127.0.0.1:8001")
                // spring5.3.1的CorsFilter类针对CorsConfiguration新增了校验
                .allowedOriginPatterns("*")
                // .allowedOrigins("*")  不用这个了
                // 允许发送Cookie
                .allowCredentials(true)
                // 允许所有方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
    }
}