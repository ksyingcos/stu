package org.stu.spring.cloud.admin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class AdminServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(AdminServerApplication.class, args);
  }

}
