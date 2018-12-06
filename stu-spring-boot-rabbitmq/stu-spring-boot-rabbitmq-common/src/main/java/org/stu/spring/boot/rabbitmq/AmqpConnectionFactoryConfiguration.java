package org.stu.spring.boot.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(ConnectionFactory.class)
@ConditionalOnExpression("'${spring.rabbitmq.addresses:}'!=''")
public class AmqpConnectionFactoryConfiguration {

  @Value("${spring.rabbitmq.addresses:}")
  private String addresses;

  @Value("${spring.rabbitmq.username:}")
  private String username;

  @Value("${spring.rabbitmq.password:}")
  private String password;

  @Value("${spring.rabbitmq.virtualHost:/}")
  private String virtualHost;

  @Value("${spring.rabbitmq.publisher-confirms:false}")
  private Boolean publisherConfirms;

  @Bean
  public ConnectionFactory amqpConnectionFactory() {

    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setAddresses(addresses);
    connectionFactory.setUsername(username);
    connectionFactory.setPassword(password);
    connectionFactory.setVirtualHost(virtualHost);
    connectionFactory.setPublisherConfirms(publisherConfirms);
    return connectionFactory;
  }

}
