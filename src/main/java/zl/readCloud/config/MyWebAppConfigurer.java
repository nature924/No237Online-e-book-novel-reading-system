package zl.readCloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author：ZhangLei
 */
@Slf4j
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

   @Value("${winResource.imgPath}")
   private String windowsFilepath;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String windowsFilepathPre = System.getProperty("user.dir").replace('\\', '/');
        log.info("路径为: "+ windowsFilepathPre + windowsFilepath);
        // 映射资源路径
        registry.addResourceHandler("/**")
                // 将资源映射到配置的文件夹
                .addResourceLocations("file:" + windowsFilepathPre + windowsFilepath);

    }


}
