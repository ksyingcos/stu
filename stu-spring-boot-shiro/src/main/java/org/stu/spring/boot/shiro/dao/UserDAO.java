package org.stu.spring.boot.shiro.dao;

import org.stu.spring.boot.shiro.entity.User;

public interface UserDAO {

  User selectUserByName(String username);

  void insertUser(User user);
}
