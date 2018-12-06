package org.stu.spring.boot.rabbitmq;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.springframework.boot.autoconfigure.amqp" })
@ConditionalOnBean(ConnectionFactory.class)
public class SimpleRabbitListenerContainerFactoryConfiguration {

  @Value("${spring.rabbitmq.listener.simple.default-requeue-rejected:false}")
  private Boolean defaultRequeueRejected;

  @Bean(name = "simpleRabbitListenerContainerFactory")
  public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(
      SimpleRabbitListenerContainerFactoryConfigurer configurer,
      ConnectionFactory amqpConnectionFactory) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    configurer.configure(factory, amqpConnectionFactory);
    factory.setDefaultRequeueRejected(defaultRequeueRejected);
    return factory;
  }

}
