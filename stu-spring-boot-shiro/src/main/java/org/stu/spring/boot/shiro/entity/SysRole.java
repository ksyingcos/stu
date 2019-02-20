package org.stu.spring.boot.shiro.entity;

import java.util.List;

public class SysRole {

  private Integer id;
  private String role;
  private List<SysPermission> permissions;
  private List<User> users;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public List<SysPermission> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<SysPermission> permissions) {
    this.permissions = permissions;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
