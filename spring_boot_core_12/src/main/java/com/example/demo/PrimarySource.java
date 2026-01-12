package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.Invoice;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo"})
public class PrimarySource {

	
	@Bean
	@Primary  // use this when you want control which bean among given set of configuration to be wired
	Invoice invoice() {
		
		return Invoice.builder().inoviceNumber(120).customerName("Ramesh").amount(2600).build();
		
	}
	
	@Bean
	Invoice invoiceTwo() {
		
		return Invoice.builder().inoviceNumber(220).customerName("Suresh").amount(3600).build();
		
	}
	
	@Bean
	Invoice invoiceThree() {
		
		return Invoice.builder().inoviceNumber(320).customerName("Magesh").amount(4600).build();
		
	}
}
