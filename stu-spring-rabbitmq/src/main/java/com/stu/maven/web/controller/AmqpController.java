package com.stu.maven.web.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stu.maven.web.model.User;

@RestController
@RequestMapping("/amqp")
public class AmqpController {
  
  @Autowired
  AmqpTemplate amqpTemplate;
  
  @RequestMapping("/send")
  public String sendAmqp(User message){
    amqpTemplate.convertAndSend(message);
    return "success";
  }

}
