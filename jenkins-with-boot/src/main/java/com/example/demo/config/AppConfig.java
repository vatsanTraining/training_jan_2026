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
	
	@Bean
	Hotel beachfront() {
		
		return new Hotel(3020, "nyle","Pondy", 600340);
		
		
	}
	
	@Bean
	Hotel restaurant() {
		
		return new Hotel(4020, "Taj","Pondy", 600340);
		
		
	}
}
