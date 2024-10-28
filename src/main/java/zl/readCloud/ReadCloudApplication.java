package zl.readCloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@MapperScan("zl.readCloud.dao")
@SpringBootApplication
@EnableScheduling
public class ReadCloudApplication {

    private static Application mApplication;

    public static void main(String[] args) {
        // mApplication = new Application();
        SpringApplication.run(ReadCloudApplication.class, args);
    }

}
