package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.Hotel;

@Configuration
public class AppConfig {

	
	
	@Bean
	Hotel hotel() {
		
		return new Hotel(1020, "Sangeetha","Chennai", 600040);
		
		
	}
	
	@Bean
	Hotel drivein() {
		
		return new Hotel(2020, "woodland","Madurai", 600240);
		
		
	}
	
}
