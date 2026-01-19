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

import com.example.demo.entity.Invoice;
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
	
		
		Invoice invoice = ctx.getBean(Invoice.class);

		System.out.println(ctx.getBean(InvoiceService.class).save(invoice));
		
		
		//ctx.close();
	}

	
	@Bean
	AuditorAware<String> auditBean(){
	    return () -> Optional.of("guestUser");
	}
	
	@Bean
	Invoice invoice() {
		
		return new Invoice(1034, "Rakesh",LocalDate.now(), 7000,Status.GENERATED); 
	}
	
	@Bean
	CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			
			@Autowired
			InvoiceRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new Invoice(1030, "Rakesh",LocalDate.now(), 8000,Status.GENERATED));
				repo.save(new Invoice(1040, "Rangesh",LocalDate.now(), 9000,Status.GENERATED));

			}
		};
	}
}
