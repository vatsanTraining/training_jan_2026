package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.Review;

@Configuration
public class AppConfig {

	
	
	@Bean
	Review review() {
		
		return new Review("abc","Sangeetha",4.5);
		
		
	}
}
