package org.stu.spring.boot.mqtt;

import org.springframework.messaging.Message;

/**
 * <strong>Description : </strong> 发送MQTT消息的网关
 * <br>
 * <strong>Create on : </strong> 2018/11/22
 * <br>
 * <p>
 *
 * @author ShiYing.Ke
 * @since 2.0.0
 */
public interface SimpleMqttGateway {

  <T> void sendMessage(T payload);

  <T> void sendMessage(String topic, T payload);

  <T> void sendMessage(String topic, T payload, int qos);

  <T> void sendMessage(String topic, T payload, boolean retained);

  <T> void sendMessage(String topic, T payload, int qos, boolean retained);

  <T> void sendMessage(Message<T> message);
}
