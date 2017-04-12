package cn.evun.stu.spring.integration.mqtt;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PubApp {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        "applicationContext-publish.xml");
    // MqttPahoMessageHandler mqtt = (MqttPahoMessageHandler)
    // ctx.getBean("mqtt");
    // Message<?> message = MessageBuilder.withPayload(new Date().toString())
    // .setHeader(MqttHeaders.TOPIC, "message/1310/ADMIN").build();
    // mqtt.handleMessage(message);
    // System.out.println("message sended.");
    // mqtt.stop();
    PubGateway gateway = ctx.getBean(PubGateway.class);
    Message<?> message = MessageBuilder.withPayload(new Date().toString())
        .setHeader(MqttHeaders.TOPIC, "message/1310/ADMIN").build();
    gateway.sendMessage(message);
    System.out.println("message sended.");
  }

}
