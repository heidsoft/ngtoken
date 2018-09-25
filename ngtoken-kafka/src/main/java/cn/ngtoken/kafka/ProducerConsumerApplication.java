package cn.ngtoken.kafka;

import cn.ngtoken.kafka.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: ngtoken
 * @description: 测试kafka
 * @author: bin.liu
 * @create: 2018-09-25 13:10
 **/
@SpringBootApplication
public class ProducerConsumerApplication implements CommandLineRunner{

    @Autowired
    private Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(ProducerConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sender.send("Spring Kafka Producer and Consumer Example");
    }
}
