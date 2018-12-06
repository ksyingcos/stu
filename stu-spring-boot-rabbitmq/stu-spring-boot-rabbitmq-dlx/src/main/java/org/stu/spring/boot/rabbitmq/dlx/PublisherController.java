package org.stu.spring.boot.rabbitmq.dlx;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stu.spring.boot.rabbitmq.SimpleAmqpSender;

import javax.annotation.Resource;

@RestController
public class PublisherController {

  @Resource
  private SimpleAmqpSender simpleAmqpSender;

  @RequestMapping("/")
  public String greeting(String routingKey) {
    simpleAmqpSender.sendMessage(routingKey, "test test");
    return "Hello World!";
  }
}
