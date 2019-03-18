package com.poc.topicexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqTopicExchangeConsumerApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RabbitmqTopicExchangeConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqTopicExchangeConsumerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info(" trying to pull the messages from RabbitMQ server ");
    }

}
