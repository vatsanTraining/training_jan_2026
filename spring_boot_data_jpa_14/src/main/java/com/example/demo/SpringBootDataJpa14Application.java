package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Invoice;
import com.example.demo.repos.InvoiceRepository;
import com.example.demo.services.InvoiceService;

@SpringBootApplication
public class SpringBootDataJpa14Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringBootDataJpa14Application.class, args);
	
		
		ctx.getBean(InvoiceService.class).findAll().forEach(System.out::println);
	
		
		Invoice invoice = ctx.getBean(Invoice.class);

		System.out.println(ctx.getBean(InvoiceService.class).save(invoice));
		
		
	}

	
	
	@Bean
	CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			
			@Autowired
			InvoiceRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new Invoice(1010, "Ramesh",LocalDate.now(), 6000));
				repo.save(new Invoice(1020, "Lokesh",LocalDate.now(), 7000));

			}
		};
	}
}
