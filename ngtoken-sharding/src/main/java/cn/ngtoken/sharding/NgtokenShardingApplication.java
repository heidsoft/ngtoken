package cn.ngtoken.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.ngtoken.sharding.mapper")
public class NgtokenShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(NgtokenShardingApplication.class, args);
    }

}

