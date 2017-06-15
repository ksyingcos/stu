package org.stu.spring.cloud.app2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ComputeService {

  @Autowired
  RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "addServiceFallback")
  public String addService(Integer a, Integer b) {
    String url = "http://APP1/add?a=" + a + "&b=" + b;
    return restTemplate.getForEntity(url, String.class).getBody();
  }

  public String addServiceFallback(Integer a, Integer b) {
    return "error";
  }

}
