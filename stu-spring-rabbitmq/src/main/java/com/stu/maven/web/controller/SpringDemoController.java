package com.stu.maven.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class SpringDemoController {

  @RequestMapping(value = "/hello")
  public String hello() {
    return "hello";
  }

}
