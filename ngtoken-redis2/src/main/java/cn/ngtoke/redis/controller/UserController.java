package cn.ngtoke.redis.controller;

import cn.ngtoke.redis.entity.User;
import cn.ngtoke.redis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

  private final Logger LOG = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserService userService;


  @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public Optional getUser(@PathVariable String userId) {
    LOG.info("Getting user with ID {}.", userId);
    return userService.findById(Long.valueOf(userId));
  }

  @CachePut(value = "users", key = "#user.id")
  @PutMapping("/update")
  public User updatePersonByID(@RequestBody User user) {
    userService.save(user);
    return user;
  }

  @CacheEvict(value = "users", allEntries=true)
  @DeleteMapping("/{id}")
  public void deleteUserByID(@PathVariable Long id) {
    LOG.info("deleting person with id {}", id);
    userService.delete(id);
  }
}