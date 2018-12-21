package cn.ngtoken.sharding;

import cn.hutool.core.lang.Console;
import cn.ngtoken.sharding.entity.EmployeeEntity;
import cn.ngtoken.sharding.mapper.EmployeeMapper;
import io.shardingjdbc.core.api.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {NgtokenShardingApplication.class})
public class NgtokenShardingApplicationTests {

    @Resource
    EmployeeMapper employeeMapper;


    @Test
    public void testMasterSlave() {
        // search slave db;
        Console.log("search slave db:");
        for (int i = 0; i < 4; i++) {
            ((Runnable) () -> {
                Console.log(employeeMapper.selectById(1));
            }).run();
        }
        Console.log("==========================================\n");

        EmployeeEntity employeeEntity = EmployeeEntity.builder().name("test").from("write master db").build();
        Integer insert = employeeMapper.insert(employeeEntity);
        Console.log("write master db: {}", insert > 0); // true
        Console.log("==========================================\n");

        EmployeeEntity ret = employeeMapper.selectOne(employeeEntity);
        Console.log("search by \"write master db\": {}", ret); // null
        Console.log("==========================================\n");

        //强制路由,访问masterdb数据
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        ret = employeeMapper.selectOne(employeeEntity); //(id=9, name=test, from=write master db)
        Console.log("[HintManager]search by \"write master db\": {}", ret);
        hintManager.close();
    }
}