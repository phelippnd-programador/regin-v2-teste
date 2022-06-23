package br.com.pscs.reginprocessoservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class BeansConfig {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
