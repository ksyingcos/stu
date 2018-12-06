package org.stu.spring.boot.rabbitmq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ConditionalOnBean(ConnectionFactory.class)
public class SimpleExchangeConfiguration {

  public static final String DEFAULT_DIRECT_EXCHANGE = "stu.default.direct.exchange";

  public static final String DEFAULT_TOPIC_EXCHANGE = "stu.default.topic.exchange";

  public static final String DEFAULT_FANOUT_EXCHANGE = "stu.default.fanout.exchange";

  public static final String DEFAULT_HEADERS_EXCHANGE = "stu.default.headers.exchange";

  @Bean
  public DirectExchange defaultDirectExchange() {
    return new DirectExchange(DEFAULT_DIRECT_EXCHANGE);
  }

  @Bean
  public TopicExchange defaultTopicExchange() {
    return new TopicExchange(DEFAULT_TOPIC_EXCHANGE);
  }

  @Bean
  public FanoutExchange defaultFanoutExchange() {
    return new FanoutExchange(DEFAULT_FANOUT_EXCHANGE);
  }

  @Bean
  public HeadersExchange defaultHeadersExchange() {
    return new HeadersExchange(DEFAULT_HEADERS_EXCHANGE);
  }
}
