package br.com.pscs.reginprocessoservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;




@Configuration
public class RabbitConfig {
	@Value("${queue.name}")
	public String queueName;
	@Bean
	@Primary
	public Queue queue() {
		return new Queue(queueName,true);
	}
	@Bean("junta_comercial")
	public Queue queueJunta() {
		return new Queue("junta_comercial",true);
	}

}
