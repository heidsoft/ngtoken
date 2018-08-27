package main.java.cn.ngtoken.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy

/**
 * @author heidsoft
 */
public class NgTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgTokenApplication.class, args);
	}
}
