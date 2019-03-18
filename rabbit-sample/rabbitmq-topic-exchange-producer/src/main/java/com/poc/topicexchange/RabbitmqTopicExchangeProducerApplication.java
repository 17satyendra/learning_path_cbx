package com.poc.topicexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poc.topicexchange.services.ProducerService;

@SpringBootApplication
public class RabbitmqTopicExchangeProducerApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RabbitmqTopicExchangeProducerApplication.class);

    @Autowired
    private ProducerService producerService;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqTopicExchangeProducerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info(" producer application is up and running");
        producerService.produce();
    }

	

}
