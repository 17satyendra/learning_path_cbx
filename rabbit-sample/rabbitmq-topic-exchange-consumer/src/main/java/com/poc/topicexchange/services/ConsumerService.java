package com.poc.topicexchange.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.poc.topicexchange.models.Car;

@Component
@RabbitListener(queues = {"all_cars_queue", "nissan_cars_queue", "toyota_cars_queue"})
public class ConsumerService
{
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @RabbitHandler
    public void receiveMessage(Object car)
    {
        logger.info(" receive message [" + car + "] ");
    }
}