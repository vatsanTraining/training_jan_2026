package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class AppConfig {

	
	
	@Bean
	WebClient.Builder builder() {
		
         return WebClient.builder();		
		
	}
	
	@Bean
	WebClient client(WebClient.Builder builder) {
		
		return builder.build();
	}





}