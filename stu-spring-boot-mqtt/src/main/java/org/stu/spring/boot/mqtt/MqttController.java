package org.stu.spring.boot.mqtt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MqttController {

  @Resource
  private SimpleMqttGateway simpleMqttGateway;

  @RequestMapping(value = "/send")
  public void send(
      @RequestParam(value = "topic", required = false) String topic,
      @RequestParam(value = "message") String message,
      @RequestParam(value = "qos", required = false) Integer qos,
      @RequestParam(value = "retained", required = false) Boolean retained) {
    if (null != qos && null != retained) {
      simpleMqttGateway.sendMessage(topic, message, qos, retained);
    } else if (null != qos) {
      simpleMqttGateway.sendMessage(topic, message, qos);
    } else if (null != retained) {
      simpleMqttGateway.sendMessage(topic, message, retained);
    } else if (null != topic) {
      simpleMqttGateway.sendMessage(topic, message);
    } else {
      simpleMqttGateway.sendMessage(message);
    }
  }
}
