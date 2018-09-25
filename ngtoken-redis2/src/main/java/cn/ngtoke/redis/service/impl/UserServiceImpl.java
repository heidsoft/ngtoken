package cn.ngtoke.redis.service.impl;

import cn.ngtoke.redis.entity.User;
import cn.ngtoke.redis.repository.UserRepository;
import cn.ngtoke.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: ngtoken
 * @description: 用户服务实现
 * @author: heidsoft
 * @create: 2018-09-25 19:29
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional findById(Long aLong) {
        return userRepository.findById(aLong);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {

    }
}
