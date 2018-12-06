package org.stu.spring.boot.rabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;

/**
 * <strong>Description : </strong> 消息过期时间Processor
 * <br>
 * <strong>Create on : </strong> 2018/12/6
 * <br>
 * <p>
 *
 * @author ShiYing.Ke
 * @since 2.0.0
 */
public class TTLMessagePostProcessor implements MessagePostProcessor {

  private long expiration;

  public TTLMessagePostProcessor(long expiration) {
    this.expiration = expiration;
  }

  @Override
  public Message postProcessMessage(Message message) throws AmqpException {
    MessageProperties messageProperties = message.getMessageProperties();
    // 设置过期时间
    messageProperties.setExpiration(String.valueOf(expiration));
    return message;
  }
}
