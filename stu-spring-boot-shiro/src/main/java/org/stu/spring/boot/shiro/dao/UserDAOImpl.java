package org.stu.spring.boot.shiro.dao;

import org.springframework.stereotype.Repository;
import org.stu.spring.boot.shiro.entity.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {

  private static final Map<String, User> userMap = new HashMap<String, User>();

  @Override
  public User selectUserByName(String username) {
    return userMap.get(username);
  }

  @Override
  public void insertUser(User user) {
    userMap.put(user.getUsername(), user);
  }
}
