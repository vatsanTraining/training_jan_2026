package com.example.demo;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.dto.InvoiceDto;
import com.example.demo.entity.Invoice;
import com.example.demo.model.Address;
import com.example.demo.repos.InvoiceRepository;
import com.example.demo.services.InvoiceService;
import com.example.demo.utils.Status;
import com.zaxxer.hikari.pool.HikariPool;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditBean")
public class SpringBootDataJpa14Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringBootDataJpa14Application.class, args);
	
		
		ctx.getBean(InvoiceService.class).findAll().forEach(System.out::println);
	
		
		InvoiceDto dto = ctx.getBean(InvoiceDto.class);

		System.out.println(ctx.getBean(InvoiceService.class).save(dto));
		
		
		//ctx.close();
	}

	
	@Bean
	AuditorAware<String> auditBean(){
	    return () -> Optional.of("guestUser");
	}
	
	@Bean
	InvoiceDto dto() {
		
		Address billing = new Address("Gandhi street", "indira nagar", "rajiv garden", 6002334);
		
		Address shipping = billing;
		
		return new InvoiceDto(1037, "Ratan",LocalDate.now(), 8000,Status.GENERATED,billing,shipping); 
	}
	
	@Bean
	CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			
			@Autowired
			InvoiceRepository repo;
			
			
			@Override
			public void run(String... args) throws Exception {
			
				Address billing = new Address("Anna street", "Thambi nagar", "appa garden", 6003334);
				
				Address shipping = new Address("Sivaji street", "sambaji nagar", "pune", 4002334);
				
				repo.save(new Invoice(2032, "Leena",LocalDate.now(), 28000,Status.RECEIVED,billing,shipping));

			}
		};
	}
}
