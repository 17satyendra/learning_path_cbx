package com.poc.rabbitconsumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.poc.rabbitconsumer.model.Order;

@Component
@RabbitListener(queues= {"orders_queue"})
public class DirectConsumer {
	private static final Logger logger = LoggerFactory.getLogger(DirectConsumer.class);

	@RabbitHandler
	public void receiveMessage(Order order) {
		logger.info(" receive message [" + order.toString() + "] ");
	}
}
