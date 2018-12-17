package cn.ngtoken.cache.controller;

import cn.ngtoken.cache.entity.Customer;
import cn.ngtoken.cache.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: ngtoken
 * @description: 缓存测试
 * @author: heidsoft
 * @create: 2018-12-14 16:55
 **/
@RestController
public class CacheController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/api/put/cache")
    public String restPutCache(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("putKey","random1="+Math.random());
        return valueOperations.get("putKey");
    }

    @PostMapping("/api/create/customer")
    @ResponseStatus(HttpStatus.OK)
    public boolean restCreateCustomer(@RequestBody Customer customer){
        LOGGER.info("first name {}, last name {}",customer.getFirstName(),customer.getLastName());
        return customerService.createUser(customer);
    }

    @GetMapping("/api/list/customer")
    public List<Customer> restListCustomer(){
        LOGGER.info("api list");
        return customerService.listCustomer();
    }

    @GetMapping("/api/list/customer/{id}")
    public Customer restGetCustomerById(@PathVariable Long id){
        LOGGER.info("api list by id");
        return customerService.findCustomerById(id);
    }

}
