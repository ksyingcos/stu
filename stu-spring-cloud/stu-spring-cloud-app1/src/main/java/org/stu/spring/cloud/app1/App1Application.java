package org.stu.spring.cloud.app1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class App1Application 
{
  public static void main(String[] args) {
    new SpringApplicationBuilder(App1Application.class).web(true).run(args);
  }
}
