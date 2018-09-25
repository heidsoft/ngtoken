package cn.ngtoke.redis.service;


import java.util.Optional;
import cn.ngtoke.redis.entity.User;

/**
 * @program: ngtoken
 * @description: test service
 * @author: heidsoft
 * @create: 2018-09-25 19:07
 **/
public interface UserService {

    Optional findById(Long aLong);

    void save(User user);

    void delete(Long id);
}
