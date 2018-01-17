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
public class DemoOneListener {
  public static final String QUEUE_NAME = "stu.spring.boot.rabbitmq.demoOne";

  public static final String ROUTING_KEY = "stu.spring.boot.rabbitmq.one";

  @Bean
  Queue demoOneQueue() {
    return new Queue(QUEUE_NAME, true); //队列持久

  }

  @Bean
  Binding demoOneBinding(DirectExchange defaultDirectExchange) {
    return BindingBuilder.bind(demoOneQueue())
        .to(defaultDirectExchange).with(ROUTING_KEY);
  }

  @Bean
  SimpleMessageListenerContainer demoOneListenerContainer(
      ConnectionFactory amqpConnectionFactory) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(amqpConnectionFactory);
    container.setQueueNames(QUEUE_NAME);
    container.setMessageListener(demoOneListenerAdapter());
    return container;
  }

  @Bean
  MessageListenerAdapter demoOneListenerAdapter() {
    MessageListenerAdapter m = new MessageListenerAdapter(
        demoOneHandler(), "handleMessage");
    //m.setMessageConverter(new JsonMessageConverter());
    return m;
  }

  @Bean
  public DemoOneHandler demoOneHandler() {
    return new DemoOneHandler();
  }
}
