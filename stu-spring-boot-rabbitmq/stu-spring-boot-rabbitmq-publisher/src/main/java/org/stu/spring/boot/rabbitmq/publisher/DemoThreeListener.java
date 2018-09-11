package org.stu.spring.boot.rabbitmq.publisher;

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
public class DemoThreeListener {
  public static final String QUEUE_NAME = "stu.spring.boot.rabbitmq.demoThree";

  public static final String ROUTING_KEY = "stu.spring.boot.rabbitmq.one";

  @Bean
  Queue demoThreeQueue() {
    return new Queue(QUEUE_NAME, true); //队列持久

  }

  @Bean
  Binding demoThreeBinding(DirectExchange defaultDirectExchange) {
    return BindingBuilder.bind(demoThreeQueue())
        .to(defaultDirectExchange).with(ROUTING_KEY);
  }

  @Bean
  SimpleMessageListenerContainer demoThreeListenerContainer(
      ConnectionFactory amqpConnectionFactory) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(amqpConnectionFactory);
    container.setQueueNames(QUEUE_NAME);
    container.setMessageListener(demoThreeListenerAdapter());
    return container;
  }

  @Bean
  MessageListenerAdapter demoThreeListenerAdapter() {
    MessageListenerAdapter m = new MessageListenerAdapter(
        demoThreeHandler(), "handleMessage");
    //m.setMessageConverter(new JsonMessageConverter());
    return m;
  }

  @Bean
  public DemoThreeHandler demoThreeHandler() {
    return new DemoThreeHandler();
  }
}
