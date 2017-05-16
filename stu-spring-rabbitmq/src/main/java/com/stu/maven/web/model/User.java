package com.stu.maven.web.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

  /** 
   * serialVersionUID
   */ 
  private static final long serialVersionUID = 1L;

  private int userId;
  
  private String userName;
  
  private List<Role> roles;
  
  private List<User> children;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public List<User> getChildren() {
    return children;
  }

  public void setChildren(List<User> children) {
    this.children = children;
  }

}
