package org.stu.spring.boot.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

import java.util.UUID;

public class SimpleAmqpSenderImpl
    implements SimpleAmqpSender, RabbitTemplate.ConfirmCallback {

  private static final Logger LOG = LoggerFactory
      .getLogger(SimpleAmqpSenderImpl.class);

  private RabbitTemplate rabbitTemplate;

  public SimpleAmqpSenderImpl(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
    this.rabbitTemplate.setConfirmCallback(this);
  }

  @Override
  public void confirm(CorrelationData correlationData, boolean ack,
      String cause) {
    if (ack) {
      LOG.info("message " + correlationData + " send success.");
    } else {
      LOG.info("message " + correlationData + " send fail, case: " + cause);
    }
  }

  @Override
  public <T> void sendMessage(String routingKey, T payload) {
    CorrelationData correlationId = new CorrelationData(
        UUID.randomUUID().toString());
    sendMessage(routingKey, payload, correlationId);
  }

  @Override
  public <T> void sendMessage(String routingKey, T payload,
      CorrelationData correlationData) {
    sendMessage(SimpleExchangeConfiguration.DEFAULT_DIRECT_EXCHANGE, routingKey,
        payload, correlationData);
  }

  @Override
  public <T> void sendMessage(String exchange, String routingKey, T payload,
      CorrelationData correlationData) {
    this.rabbitTemplate
        .convertAndSend(exchange, routingKey, payload, correlationData);
  }

  @Override
  public <T> void sendMessage(String routingKey, T payload, long expiration) {
    sendMessage(SimpleExchangeConfiguration.DEFAULT_DIRECT_EXCHANGE, routingKey,
        payload, expiration);
  }

  @Override
  public <T> void sendMessage(String exchange, String routingKey, T payload,
      final long expiration) {
    MessagePostProcessor messagePostProcessor = new TTLMessagePostProcessor(
        expiration);
    sendMessage(exchange, routingKey, payload, messagePostProcessor);
  }

  @Override
  public <T> void sendMessage(String exchange, String routingKey, T payload,
      MessagePostProcessor messagePostProcessor) {
    CorrelationData correlationId = new CorrelationData(
        UUID.randomUUID().toString());
    sendMessage(exchange, routingKey, payload, messagePostProcessor,
        correlationId);
  }

  @Override
  public <T> void sendMessage(String exchange, String routingKey, T payload,
      MessagePostProcessor messagePostProcessor,
      CorrelationData correlationData) {
    this.rabbitTemplate
        .convertAndSend(exchange, routingKey, payload, messagePostProcessor,
            correlationData);
  }
}
