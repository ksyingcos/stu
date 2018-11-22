package org.stu.spring.boot.mqtt;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <strong>Description : </strong> 发送MQTT消息的网关，不用接口注入动态代理的bean会报错
 * <br>
 * <strong>Create on : </strong> 2018/11/22
 * <br>
 * <p>
 *
 * @author ShiYing.Ke
 * @since 2.0.0
 */
@Component
@ConditionalOnBean(MqttConfiguration.MqttGateway.class)
public class SimpleMqttGatewayImpl implements SimpleMqttGateway {

  @Resource
  private MqttConfiguration.MqttGateway mqttGateway;

  @Override
  public <T> void sendMessage(T payload) {
    Message<T> message = MessageBuilder.withPayload(payload).build();
    this.sendMessage(message);
  }

  @Override
  public <T> void sendMessage(String topic, T payload) {
    Message<T> message = MessageBuilder.withPayload(payload)
        .setHeader(MqttHeaders.TOPIC, topic).build();
    this.sendMessage(message);
  }

  @Override
  public <T> void sendMessage(String topic, T payload, int qos) {
    Message<T> message = MessageBuilder.withPayload(payload)
        .setHeader(MqttHeaders.TOPIC, topic).setHeader(MqttHeaders.QOS, qos)
        .build();
    this.sendMessage(message);
  }

  @Override
  public <T> void sendMessage(String topic, T payload, boolean retained) {
    Message<T> message = MessageBuilder.withPayload(payload)
        .setHeader(MqttHeaders.TOPIC, topic)
        .setHeader(MqttHeaders.RETAINED, retained).build();
    this.sendMessage(message);
  }

  @Override
  public <T> void sendMessage(String topic, T payload, int qos,
      boolean retained) {
    Message<T> message = MessageBuilder.withPayload(payload)
        .setHeader(MqttHeaders.TOPIC, topic).setHeader(MqttHeaders.QOS, qos)
        .setHeader(MqttHeaders.RETAINED, retained).build();
    this.sendMessage(message);
  }

  @Override
  public <T> void sendMessage(Message<T> message) {
    mqttGateway.send(message);
  }
}
