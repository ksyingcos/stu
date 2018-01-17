package org.stu.spring.boot.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoTwoHandler {

  private static final Logger LOG = LoggerFactory
      .getLogger(DemoTwoHandler.class);

  public void handleMessage(String message) {

    try {
      System.out.println("demo two receive msg : " + message);
    } catch (Exception ex) {
      LOG.error("{}", ex);
    }
  }
}
