package com.tigris.spring_kafka.config; 

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

  @Bean
  public NewTopic tigrisTopic(){
    return new NewTopic("tigris", 1, (short) 1);
  } 
}
