package cn.ngtoke.redis.repository;

import cn.ngtoke.redis.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @program: ngtoken
 * @description: hello
 * @author: heidsoft
 * @create: 2018-09-25 17:58
 **/
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
