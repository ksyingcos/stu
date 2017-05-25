package com.stu.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.stu.springboot.controller")
public class HelloWorldApplication implements CommandLineRunner{

  public static void main(String[] args) {
    new SpringApplication(HelloWorldApplication.class).run( args);
  }

  public void run(String... args) throws Exception {
    System.out.println(args);
  }
}
