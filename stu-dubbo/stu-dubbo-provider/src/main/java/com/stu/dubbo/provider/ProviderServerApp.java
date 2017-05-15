package com.stu.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class ProviderServerApp {
  public static void main(String[] args) {
    try {
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
          "provider.xml");
      context.start();
      System.in.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
