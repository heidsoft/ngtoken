package cn.ngtoken.logs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heidsoft
 */
@SpringBootApplication(scanBasePackages = "cn.ngtoken.logs")
public class NgtokenLogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NgtokenLogsApplication.class, args);
    }
}
