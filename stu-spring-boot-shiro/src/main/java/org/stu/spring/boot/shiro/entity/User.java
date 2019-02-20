package org.stu.spring.boot.shiro.entity;

import java.util.List;

public class User {

  private long id;
  private String username;
  private String password;
  private String salt;
  private List<SysRole> roles;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public List<SysRole> getRoles() {
    return roles;
  }

  public void setRoles(List<SysRole> roles) {
    this.roles = roles;
  }

  public String getCredentialsSalt() {
    return username + salt + salt;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + "]";
  }
}
