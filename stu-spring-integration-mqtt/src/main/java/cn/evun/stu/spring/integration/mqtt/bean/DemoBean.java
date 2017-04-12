package cn.evun.stu.spring.integration.mqtt.bean;

import org.springframework.stereotype.Component;

@Component
public class DemoBean {
  
  private int id = 1;
  
  private String name = "demo";

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
