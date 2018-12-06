package org.stu.spring.boot.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class QueueBuilder {

  private String name;

  private boolean durable;

  private boolean exclusive;

  private boolean autoDelete;

  private java.util.Map<java.lang.String, java.lang.Object> arguments;

  private QueueBuilder(String name) {
    this(name, true);
  }

  private QueueBuilder(String name, boolean durable) {
    this(name, durable, false, false);
  }

  private QueueBuilder(String name, boolean durable, boolean exclusive,
      boolean autoDelete) {
    this(name, durable, exclusive, autoDelete, null);
  }

  private QueueBuilder(String name, boolean durable, boolean exclusive,
      boolean autoDelete, Map<String, Object> arguments) {
    Assert.notNull(name, "'name' cannot be null");
    this.name = name;
    this.durable = durable;
    this.exclusive = exclusive;
    this.autoDelete = autoDelete;
    this.arguments = arguments;
  }

  public static QueueBuilder withName(String queueName) {
    return new QueueBuilder(queueName);
  }

  public static QueueBuilder withDLX(String queueName) {
    return withDLX(queueName, SimpleDeadLetterConfiguration.DEFAULT_DL_EXCHANGE,
        SimpleDeadLetterConfiguration.DEFAULT_DL_ROUTING_KEY);
  }

  public static QueueBuilder withDLX(String queueName,
      String deadLetterExchange, String deadLetterRoutingKey) {

    Map<String, Object> args = new HashMap<>();
    // x-dead-letter-exchange 声明 死信交换机
    args.put("x-dead-letter-exchange", deadLetterExchange);
    // x-dead-letter-routing-key 声明 死信路由键
    args.put("x-dead-letter-routing-key", deadLetterRoutingKey);
    return new QueueBuilder(queueName, true, false, false, args);
  }

  public static QueueBuilder withTTL(String queueName, long expiration) {

    Map<String, Object> args = new HashMap<>();
    // x-message-ttl 队列过期时间 单位毫秒
    args.put("x-message-ttl", expiration);
    return new QueueBuilder(queueName, true, false, false, args);
  }

  public QueueBuilder setDurable(boolean durable) {
    this.durable = durable;
    return this;
  }

  public QueueBuilder setExclusive(boolean exclusive) {
    this.exclusive = exclusive;
    return this;
  }

  public QueueBuilder setAutoDelete(boolean autoDelete) {
    this.autoDelete = autoDelete;
    return this;
  }

  public QueueBuilder setArguments(Map<String, Object> arguments) {
    this.arguments = arguments;
    return this;
  }

  public QueueBuilder setArgument(String key, Object value) {
    if (null == arguments) {
      arguments = new HashMap<>();
    }
    this.arguments.put(key, value);
    return this;
  }

  public QueueBuilder setMessageTTL(long expiration) {
    return setArgument("x-message-ttl", expiration);
  }

  public QueueBuilder setDeadLetterExchange(String deadLetterExchange) {
    return setArgument("x-dead-letter-exchange", deadLetterExchange);
  }

  public QueueBuilder setDeadLetterRoutingKey(String deadLetterRoutingKey) {
    return setArgument("x-dead-letter-routing-key", deadLetterRoutingKey);
  }

  public Queue build() {
    return new Queue(this.name, this.durable, this.exclusive, this.autoDelete,
        this.arguments);
  }

}
