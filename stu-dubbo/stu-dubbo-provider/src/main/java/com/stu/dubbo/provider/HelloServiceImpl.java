package com.stu.dubbo.provider;

import com.stu.dubbo.service.HelloService;

public class HelloServiceImpl implements HelloService {

  public String sayHello(String name) {
    return "hello " + name;
  }

}
