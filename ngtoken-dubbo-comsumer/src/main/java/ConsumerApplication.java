import com.ngtoken.dubbo.api.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApplication {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"consumer.xml"});
        context.start();
        final IUserService userService = context.getBean("userService", IUserService.class); // 获取远程服务代理
        String hello = userService.sayHi("world"); // 执行远程方法
        System.out.println("===================================");
        System.out.println(hello); // 显示调用结果
        System.out.println("===================================");
    }
}
