package org.stu.spring.boot.mqtt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MqttApplication {

  public static void main(String[] args) {
    SpringApplication.run(MqttApplication.class, args);
    //    ConfigurableApplicationContext context = new SpringApplicationBuilder(
    //        MqttApplication.class).web(false).run(args);
  }
}
