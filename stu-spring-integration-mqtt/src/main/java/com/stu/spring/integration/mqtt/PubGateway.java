package com.stu.spring.integration.mqtt;

import org.springframework.messaging.Message;

public interface PubGateway {
  void sendMessage(Message<?> message);
}
