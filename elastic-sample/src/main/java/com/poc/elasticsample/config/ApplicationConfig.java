package com.poc.elasticsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public JestClient getJestClient() {
//		JestClientFactory factory = new JestClientFactory();
//		factory.setHttpClientConfig(new HttpClientConfig(builder));
		JestClientFactory factory = new JestClientFactory();
		HttpClientConfig.Builder builder = new HttpClientConfig.Builder("http://localhost:9200");
		factory.setHttpClientConfig(builder.build());
				
		return factory.getObject();
		 
	}
}
