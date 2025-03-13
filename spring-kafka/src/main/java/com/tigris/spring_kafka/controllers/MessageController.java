package com.tigris.spring_kafka.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tigris.spring_kafka.kafka.Producer;

@RestController
@RequestMapping("/api/v1/")
public class MessageController {

  private Producer producer;

  public MessageController(Producer producer) {
    this.producer = producer;
  }

  @PostMapping("/publish")
  public ResponseEntity<String> publish(@RequestParam("message") String message){

    producer.sendMessage(message);
    return ResponseEntity.ok("Message sent to kafka -> " + message);

  }
}
