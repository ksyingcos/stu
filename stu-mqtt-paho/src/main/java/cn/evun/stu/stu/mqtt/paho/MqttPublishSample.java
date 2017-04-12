package cn.evun.stu.stu.mqtt.paho;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublishSample {
  
  public static void main(String[] args) {

    String topic = "message/1310/ADMIN";
    String content = "Message from MqttPublishSample";
    int qos = 1;
    //String broker = "tcp://iot.eclipse.org:1883";
    //String broker = "tcp://10.86.87.137:1883";
    String broker = "tcp://10.86.87.112:1883";
    String clientId = "JavaPublishSample";
    MemoryPersistence persistence = new MemoryPersistence();

    try {
      MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
      MqttConnectOptions connOpts = new MqttConnectOptions();
      connOpts.setCleanSession(true);
      connOpts.setUserName("mqtt");
      connOpts.setPassword("hello".toCharArray());
      System.out.println("Connecting to broker: " + broker);
      sampleClient.connect(connOpts);
      System.out.println("Connected");
      System.out.println("Publishing message: " + content);
      MqttMessage message = new MqttMessage(content.getBytes());
      message.setQos(qos);
      sampleClient.publish(topic, message);
      System.out.println("Message published");
      sampleClient.disconnect();
      System.out.println("Disconnected");
      System.exit(0);
    } catch (MqttException me) {
      System.out.println("reason " + me.getReasonCode());
      System.out.println("msg " + me.getMessage());
      System.out.println("loc " + me.getLocalizedMessage());
      System.out.println("cause " + me.getCause());
      System.out.println("excep " + me);
      me.printStackTrace();
    }
  }
}
