package org.stu.spring.boot.rabbitmq.dlx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
@RabbitListener(queues = DemoBusinessQueueConfig.QUEUE_NAME, containerFactory = "simpleRabbitListenerContainerFactory")
public class DemoBusinessListener {

  private static final Logger LOG = LoggerFactory
      .getLogger(DemoBusinessListener.class);

  @RabbitHandler
  public void handleMessage(String message) throws Exception {
    LOG.info("demo four receive msg : " + message);
    throw new Exception("xxx");
  }
}
