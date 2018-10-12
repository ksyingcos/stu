package org.stu.spring.boot.jodconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("org.stu.spring.boot.jodconverter.controller")
public class JodconverterApplication {

  public static void main(String[] args) {
    SpringApplication.run(JodconverterApplication.class, args);
  }
}
