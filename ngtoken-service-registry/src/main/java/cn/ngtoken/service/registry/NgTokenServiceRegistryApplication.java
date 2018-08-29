package cn.ngtoken.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: ngtoken
 * @description: 服务注册
 * @author: heidsoft
 * @create: 2018-08-29 11:25
 **/
@SpringBootApplication
@EnableEurekaServer
public class NgTokenServiceRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(NgTokenServiceRegistryApplication.class, args);
    }
}
