package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;

@Service
@ConfigurationProperties(prefix = "com.example")
@Data
public class InvoiceService {

	
	@Autowired
	private Environment env;
	
	
	private String author;
	
	public InvoiceService() {
		super();
		
		//System.out.println(env.getProperty("server.port", String.class));
		
		System.err.println("Inside CONSTRUCTOR ");
		System.err.println(env);
	}

	
	
	@PostConstruct
	public void init() {
		

		System.out.println("Inside init method");
		System.out.println("==========="+env);
		System.out.println(env.getProperty("server.port", String.class));

	}

	@PreDestroy
	public void cleanUp() {

		System.out.println("Inside Destroy method");
		System.out.println("==========="+env);

		
	}


	public double calculateDiscount(Invoice invoice) {
		
		
		return invoice.getAmount()>5000?0.10:0.5;
		
		
	}
	
}
