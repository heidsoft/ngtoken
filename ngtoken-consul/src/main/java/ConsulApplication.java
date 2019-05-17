import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  https://cloud.spring.io/spring-cloud-consul/spring-cloud-consul.html
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class ConsulApplication {

  @RequestMapping("/")
  public String home() {
    return "Hello World";
  }

  public static void main(String[] args) {
    SpringApplication.run(ConsulApplication.class, args);
  }

}