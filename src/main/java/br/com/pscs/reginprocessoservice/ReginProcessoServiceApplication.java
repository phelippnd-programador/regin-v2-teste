package br.com.pscs.reginprocessoservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ReginProcessoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReginProcessoServiceApplication.class, args);
	}

}
