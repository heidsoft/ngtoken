package cn.ngtoken.cache.service;

import cn.ngtoken.cache.entity.Customer;
import cn.ngtoken.cache.repository.CustomerRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @program: ngtoken
 * @description: 客户service
 * @author: heidsoft
 * @create: 2018-12-17 12:00
 **/
@Service
public class CustomerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CacheManager cacheManager;

    public boolean createUser(Customer customer){
        Customer customerResult = customerRepository.save(customer);
        return customerResult == null;
    }

    public List<Customer> listCustomer(){
        LOGGER.info("list {}"," start ...");
        List<Customer> customers = customerRepository.findAll();
        LOGGER.info("list end"," end ...");
        return customers;
    }

    @Cacheable(value = {"myuser"})
    public Customer findCustomerById(Long customerId){
        LOGGER.info("findCustomerById {}",cacheManager.getCache("myuser"));
        Optional<Customer> customer = customerRepository.findById(customerId);
        LOGGER.info("findCustomerById {}",cacheManager.getCache("myuser"));
        return customer.get();
    }
}
