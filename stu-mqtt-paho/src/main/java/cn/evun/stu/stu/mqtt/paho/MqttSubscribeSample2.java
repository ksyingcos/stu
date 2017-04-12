package cn.evun.stu.stu.mqtt.paho;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttSubscribeSample2 {
  
  public static void main(String[] args){
    String[] topicFilters = {"topic1/#", "message/1310/ADMIN", "mqtt_topic"};
    int[] qos = {1, 0, 0};
    String broker = "tcp://10.86.87.112:1883";
    String clientId = "JavaSubscribeSample-2";
    MemoryPersistence persistence = new MemoryPersistence();
    try {
      MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
      MqttConnectOptions connOpts = new MqttConnectOptions();
      connOpts.setCleanSession(true);
      System.out.println("Connecting to broker: " + broker);
      sampleClient.connect(connOpts);
      System.out.println("Connected");
      sampleClient.setCallback(new MqttCallback() {
        
        public void messageArrived(String topic, MqttMessage message)
            throws Exception {
          System.out.println(topic + " message arrived: " + message.toString());
        }
        
        public void deliveryComplete(IMqttDeliveryToken token) {
          // TODO Auto-generated method stub
          
        }
        
        public void connectionLost(Throwable cause) {
          // TODO Auto-generated method stub
          
        }
      });
      sampleClient.subscribe(topicFilters, qos);
      System.out.println("Subscribe success for: " + topicFilters.toString());
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
