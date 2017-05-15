package com.stu.dubbo.consumer;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stu.dubbo.service.HelloService;

/**
 * Hello world!
 *
 */
public class ConsumerClientApp {
  public static void main(String[] args) {
    try {
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
          "consumer.xml");
      HelloService helloService = (HelloService) context
          .getBean("helloService");
      String result = helloService.sayHello("world");
      System.out.println(result);
      System.in.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
