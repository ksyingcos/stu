package org.stu.spring.boot.rabbitmq.dlx;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.stu.spring.boot.rabbitmq.QueueBuilder;

@Configuration
@ComponentScan("org.stu.spring.boot.rabbitmq")
public class DemoBusinessQueueConfig {

  public static final String QUEUE_NAME = "stu.spring.boot.rabbitmq.demoBusiness";

  @Bean
  Queue demoBusinessQueue() {
    //    Map<String, Object> args = new HashMap<>();
    //    // x-dead-letter-exchange 声明 死信交换机
    //    args.put("x-dead-letter-exchange", AmqpConfiguration.DEFAULT_DL_EXCHANGE);
    //    // x-dead-letter-routing-key 声明 死信路由键
    //    args.put("x-dead-letter-routing-key",
    //        AmqpConfiguration.DEFAULT_DL_ROUTING_KEY);
    return QueueBuilder.withDLX(QUEUE_NAME).setMessageTTL(10 * 1000).build();
  }

  @Bean
  Binding demoBusinessBinding(DirectExchange defaultDirectExchange) {
    return BindingBuilder.bind(demoBusinessQueue()).to(defaultDirectExchange)
        .withQueueName();
  }
}
