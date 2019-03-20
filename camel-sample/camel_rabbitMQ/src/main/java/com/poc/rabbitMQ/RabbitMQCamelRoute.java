package com.poc.rabbitMQ;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


public class RabbitMQCamelRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:hello?period=1000")

				.transform(simple("Random number ${random(0,100)}"))

				.to("rabbitmq://localhost/sales_data_exchange");

		from("rabbitmq://localhost/queue=orders_queue")

				.log("From RabbitMQ: ${body}");
	}

}
