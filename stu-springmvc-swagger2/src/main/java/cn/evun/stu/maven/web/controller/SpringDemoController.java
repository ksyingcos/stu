package cn.evun.stu.maven.web.controller;

import io.swagger.annotations.Api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "演示接口")
@Controller
@RequestMapping("/demo")
public class SpringDemoController {

  @RequestMapping(value = "/hello")
  public String hello() {
    return "hello";
  }

}
