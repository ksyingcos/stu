package org.stu.spring.boot.shiro.entity;

import java.util.List;

public class SysPermission {

  private Integer id;
  private String name;
  private List<SysRole> roles;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SysRole> getRoles() {
    return roles;
  }

  public void setRoles(List<SysRole> roles) {
    this.roles = roles;
  }
}
