package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.services.InvoiceService;

@SpringBootApplication
public class SpringBootJdbc13Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext	 ctx=SpringApplication.run(SpringBootJdbc13Application.class, args);
	
	
InvoiceService service =	ctx.getBean(InvoiceService.class);

  service.findAll().forEach(System.out::println);

  
	}

}
