package com.poc.producer.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.poc.producer.model.Item;
import com.poc.producer.model.Order;

@Component
public class Producer {
	@Autowired
    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private static final String EXCHANGE = "sales_data_exchange";
    private static final String ROUTING_KEY = "customer.order";


    @Scheduled(fixedRate = 1000)
    public void produce()
    {
        LOGGER.info(" Publishing the Customer Order");

        Order order = this.getOrder();
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, order);
    }


    private Order getOrder()
    {
        List<Item> orderItemList = new ArrayList<>();
        Item item1 = new Item("Phone", 1);
        orderItemList.add(item1);

        Item item2 = new Item("SIM", 1);
        orderItemList.add(item2);

        Item item3 = new Item("Charger", 1);
        orderItemList.add(item3);

        return new Order("Chathuranga Tennakoon", new Date(), "www.springbootdev.com", orderItemList);
    }
}
