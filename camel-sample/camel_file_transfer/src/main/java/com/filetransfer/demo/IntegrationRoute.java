package com.filetransfer.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class IntegrationRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:\\target\\inbox").process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				String text = exchange.getIn().getBody(String.class);
				exchange.getOut().setBody("Hello this is added in route"+text);
			}
		}).bean(new TransformationBean(), "makeUpperCase").to("file:C:\\target\\outbox");
	}

}
