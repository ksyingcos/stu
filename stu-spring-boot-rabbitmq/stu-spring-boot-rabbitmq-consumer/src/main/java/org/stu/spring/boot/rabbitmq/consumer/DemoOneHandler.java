package org.stu.spring.boot.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoOneHandler {

  private static final Logger LOG = LoggerFactory
      .getLogger(DemoOneHandler.class);

  public void handleMessage(String message) throws Exception {
    System.out.println("demo one receive msg : " + message);
    throw new Exception("ex");

//    try {
//      System.out.println("demo one receive msg : " + message);
//      throw new Exception("ex");
//    } catch (Exception ex) {
//      LOG.error("{}", ex);
//    }
  }
}
