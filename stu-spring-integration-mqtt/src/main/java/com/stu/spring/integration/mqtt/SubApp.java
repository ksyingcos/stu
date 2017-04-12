package com.stu.spring.integration.mqtt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SubApp {

  @SuppressWarnings({ "resource", "unused" })
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        "applicationContext-subscribe.xml");
  }

}
