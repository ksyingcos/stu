package org.stu.spring.boot.shiro.service;

import org.springframework.stereotype.Service;
import org.stu.spring.boot.shiro.dao.UserDAO;
import org.stu.spring.boot.shiro.entity.User;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserDAO userDAO;

  @Override
  public User findUserByName(String username) {

    return userDAO.selectUserByName(username);
  }

  @Override
  public void saveUser(User user) {

    userDAO.insertUser(user);
  }
}
