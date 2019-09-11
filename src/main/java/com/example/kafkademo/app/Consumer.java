package com.example.kafkademo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

  private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

  @KafkaListener(topics = "users", groupId = "group_id")
  public void consume(Message message) {
    logger.info(String.format("Consumed: %s", message));
    if (message.getText().startsWith("foo")) {
      throw new RuntimeException("no foo!");
    }
  }

}