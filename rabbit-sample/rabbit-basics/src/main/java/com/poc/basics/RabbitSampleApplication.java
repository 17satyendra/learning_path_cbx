package com.poc.basics;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitSampleApplication.class, args);
		/*ConnectionFactory connectionFactory = new CachingConnectionFactory("localhost", 5672);
		
		AmqpAdmin admin = new RabbitAdmin(connectionFactory);
		admin.declareQueue(new Queue("myqueue"));
		AmqpTemplate template = new RabbitTemplate(connectionFactory);
		template.convertAndSend("myqueue", "HelloWorld");
		String foo = (String) template.receiveAndConvert("myqueue");
		System.out.println(foo);*/
	}
	
	@Bean
    public ApplicationRunner runner(AmqpTemplate template) {
		Message message = MessageBuilder.withBody("foo".getBytes())
			    .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
			    .setMessageId("123")
			    .setHeader("bar", "baz")
			    .build();
        return args -> template.convertAndSend("myqueue", message);
    }
	// async Pojo Listener
    @RabbitListener(queues = "myqueue")
    public void listen(String in) {
        System.out.println(in);
    }

}
