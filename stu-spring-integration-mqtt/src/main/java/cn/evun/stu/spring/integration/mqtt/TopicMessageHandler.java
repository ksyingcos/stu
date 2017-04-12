package cn.evun.stu.spring.integration.mqtt;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class TopicMessageHandler implements MessageHandler {

  public void handleMessage(Message<?> message) throws MessagingException {
    System.out.println(message.getPayload());
  }

}
