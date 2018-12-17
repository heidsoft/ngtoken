package cn.ngtoken.cache.repository;

import cn.ngtoken.cache.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author heidsoft
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Override
    List<Customer> findAll();

    @Override
    Optional<Customer> findById(Long Id);

}