package com.thandav.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@SpringBootApplication
public class KafkaApplication {

    private final Logger logger = LoggerFactory.getLogger(KafkaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @KafkaListener(id = "testGroupId", topics = "TestTopic")
   	public void listen1(String testMessage) throws IOException {
   		logger.info("Received: " + testMessage);
   		// foos.forEach(f -> kafkaTemplate.send("topic3", f.getFoo().toUpperCase()));
   		logger.info("Messages sent, hit Enter to commit tx");
   		System.in.read();
   	}
}
