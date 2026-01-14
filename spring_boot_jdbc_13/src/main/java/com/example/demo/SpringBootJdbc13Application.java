package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.dto.Invoice;
import com.example.demo.services.InvoiceService;


@SpringBootApplication
public class SpringBootJdbc13Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext	 ctx=SpringApplication.run(SpringBootJdbc13Application.class, args);
	
	
InvoiceService service =	ctx.getBean(InvoiceService.class);


System.out.println(service.add(new Invoice(891, "Kamesh", LocalDate.now(), 19000)));

System.out.println(service.findByInvoiceNumber(103));

  service.findAll().forEach(System.out::println);

  
  ctx.close();
  
	}

}
