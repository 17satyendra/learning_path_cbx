package com.filetransfer.demo;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:\\inputFolder?noop=true").toF("file:C:\\%s", "outputFolder");
	}	
}
