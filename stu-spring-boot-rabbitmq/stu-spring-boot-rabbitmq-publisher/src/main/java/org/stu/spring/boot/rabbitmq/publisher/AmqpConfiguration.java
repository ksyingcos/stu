package org.stu.spring.boot.rabbitmq.publisher;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AmqpConfiguration {

  public static final String DEFAULT_DIRECT_EXCHANGE = "stu.default.direct.exchange";

  public static final String DEFAULT_TOPIC_EXCHANGE = "stu.default.topic.exchange";

  @Value("${spring.rabbitmq.host}")
  private String host;

  @Value("${spring.rabbitmq.port}")
  private int port;

  @Value("${spring.rabbitmq.username}")
  private String username;

  @Value("${spring.rabbitmq.password}")
  private String password;

  @Value("${spring.rabbitmq.virtualHost}")
  private String virtualHost;

  @Value("${spring.rabbitmq.publisher-confirms}")
  private Boolean publisherConfirms;

  @Bean
  public ConnectionFactory amqpConnectionFactory() {

    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setHost(host);
    connectionFactory.setPort(port);
    connectionFactory.setUsername(username);
    connectionFactory.setPassword(password);
    connectionFactory.setVirtualHost(virtualHost);
    connectionFactory.setPublisherConfirms(publisherConfirms);

    return connectionFactory;
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public RabbitTemplate rabbitTemplate() {
    RabbitTemplate template = new RabbitTemplate(amqpConnectionFactory());
    return template;
  }

  @Bean
  public DirectExchange defaultDirectExchange() {
    return new DirectExchange(DEFAULT_DIRECT_EXCHANGE);
  }

  @Bean
  public TopicExchange defaultTopicExchange() {
    return new TopicExchange(DEFAULT_TOPIC_EXCHANGE);
  }

}
