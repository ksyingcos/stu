package org.stu.spring.boot.rabbitmq.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @RequestMapping("/")
  public String greeting(String routingKey) {
    CorrelationData correlationId = new CorrelationData(
        UUID.randomUUID().toString());
    rabbitTemplate.convertAndSend(AmqpConfiguration.DEFAULT_DIRECT_EXCHANGE,
        routingKey, "test test", correlationId);
    return "Hello World!";
  }
}
