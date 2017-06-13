package org.stu.spring.boot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.stu.spring.boot.helloworld.controller")
public class HelloWorldApplication{

  public static void main(String[] args) {
    SpringApplication.run(HelloWorldApplication.class, args);
  }
}
