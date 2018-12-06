package org.stu.spring.boot.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(ConnectionFactory.class)
public class SimpleDeadLetterConfiguration {

  public static final String DEFAULT_DL_EXCHANGE = "stu.default.dead-letter.exchange";

  public static final String DEFAULT_DL_QUEUE = "stu.default.dead-letter.queue";

  public static final String DEFAULT_DL_ROUTING_KEY = "stu.default.dead-letter.routing-key";

  @Bean
  public DirectExchange defaultDLExchange() {
    return new DirectExchange(DEFAULT_DL_EXCHANGE);
  }

  @Bean
  public Queue defaultDLQueue() {
    return new Queue(DEFAULT_DL_QUEUE);
  }

  @Bean
  public Binding defaultDLQueueBinding() {
    return BindingBuilder.bind(defaultDLQueue()).to(defaultDLExchange())
        .with(DEFAULT_DL_ROUTING_KEY);
  }

}
