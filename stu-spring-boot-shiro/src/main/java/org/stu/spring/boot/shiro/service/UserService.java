package org.stu.spring.boot.shiro.service;

import org.stu.spring.boot.shiro.entity.User;

public interface UserService {

  User findUserByName(String username);

  void saveUser(User user);
}
