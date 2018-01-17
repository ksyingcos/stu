package org.stu.spring.boot.rabbitmq.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AmqpConfiguration.class)
public class DemoTwoListener {
  public static final String QUEUE_NAME = "stu.spring.boot.rabbitmq.demoTwo";

  public static final String ROUTING_KEY = "stu.spring.boot.rabbitmq.two";

  @Bean
  Queue demoTwoQueue() {
    return new Queue(QUEUE_NAME, true); //队列持久

  }

  @Bean
  Binding demoTwoBinding(DirectExchange defaultDirectExchange) {
    return BindingBuilder.bind(demoTwoQueue())
        .to(defaultDirectExchange).with(ROUTING_KEY);
  }

  @Bean
  SimpleMessageListenerContainer demoTwoListenerContainer(
      ConnectionFactory amqpConnectionFactory) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(amqpConnectionFactory);
    container.setQueueNames(QUEUE_NAME);
    container.setMessageListener(demoTwoListenerAdapter());
    return container;
  }

  @Bean
  MessageListenerAdapter demoTwoListenerAdapter() {
    MessageListenerAdapter m = new MessageListenerAdapter(
        demoTwoHandler(), "handleMessage");
    //m.setMessageConverter(new JsonMessageConverter());
    return m;
  }

  @Bean
  public DemoTwoHandler demoTwoHandler() {
    return new DemoTwoHandler();
  }
}
