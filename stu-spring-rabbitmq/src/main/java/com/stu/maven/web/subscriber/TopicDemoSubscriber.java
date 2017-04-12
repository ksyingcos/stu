package com.stu.maven.web.subscriber;

import org.springframework.stereotype.Component;

@Component
public class TopicDemoSubscriber {
  
  public void handleMessage(String message){
    System.out.println(message);
  }

}
