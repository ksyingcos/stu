package org.stu.spring.boot.rabbitmq;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan
@ConditionalOnBean(ConnectionFactory.class)
public class SimpleAmqpSenderConfiguration {

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public RabbitTemplate rabbitTemplate(
      ConnectionFactory amqpConnectionFactory) {
    return new RabbitTemplate(amqpConnectionFactory);
  }

  @Bean
  public SimpleAmqpSender simpleAmqpSender(RabbitTemplate rabbitTemplate) {
    return new SimpleAmqpSenderImpl(rabbitTemplate);
  }
}
