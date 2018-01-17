package org.stu.spring.boot.rabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoThreeHandler {

  private static final Logger LOG = LoggerFactory
      .getLogger(DemoThreeHandler.class);

  public void handleMessage(String message) throws Exception {

    try {
      System.out.println("demo three receive msg : " + message);
      throw new Exception("ex");
    } catch (Exception ex) {
      LOG.error("{}", ex);
    }
  }
}
