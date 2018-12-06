package org.stu.spring.boot.rabbitmq;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * <strong>Description : </strong> AMQP消息发送接口
 * <br>
 * <strong>Create on : </strong> 2018/12/6
 * <br>
 * <p>
 *
 * @author ShiYing.Ke
 * @since 2.0.0
 */
public interface SimpleAmqpSender {

  <T> void sendMessage(String routingKey, T payload);

  <T> void sendMessage(String routingKey, T payload,
      CorrelationData correlationData);

  <T> void sendMessage(String exchange, String routingKey, T payload,
      CorrelationData correlationData);

  <T> void sendMessage(String routingKey, T payload, long expiration);

  <T> void sendMessage(String exchange, String routingKey, T payload,
      final long expiration);

  <T> void sendMessage(String exchange, String routingKey, T payload,
      MessagePostProcessor messagePostProcessor);

  <T> void sendMessage(String exchange, String routingKey, T payload,
      MessagePostProcessor messagePostProcessor,
      CorrelationData correlationData);
}
