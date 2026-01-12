package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Invoice;
import com.example.demo.services.InvoiceService;

@SpringBootApplication
public class SpringBootCore12Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(SpringBootCore12Application.class, args);
	
	
	InvoiceService service = ctx.getBean(InvoiceService.class);
	
	
	var invoice = ctx.getBean(Invoice.class);
	
	 var discount = service.calculateDiscount(invoice);
	 
	 System.out.println("Discount Amount :=>"+ discount*invoice.getAmount());
	
	}

	
	@Bean
	Invoice invoice() {
		
		return Invoice.builder().inoviceNumber(120).customerName("Ramesh").amount(2600).build();
		
	}
}
