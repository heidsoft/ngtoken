package cn.ngtoken.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author heidsoft
 */
@SpringBootApplication
//启用缓存
@EnableCaching
public class NgtokenCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(NgtokenCacheApplication.class, args);
    }

}

