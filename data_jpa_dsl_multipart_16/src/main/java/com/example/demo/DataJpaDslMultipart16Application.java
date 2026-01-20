package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;

@SpringBootApplication
public class DataJpaDslMultipart16Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(DataJpaDslMultipart16Application.class, args);
	
	    CustomerService service = ctx.getBean(CustomerService.class);
	    
	    //Customer customer = ctx.getBean(Customer.class);
	    
//	    Customer saved=service.save(customer);
//	
//	    System.out.println("Saved Entity"+ saved);
	    
	  //  service.fetchDetails().forEach(System.out::println);
	    
	   // System.out.println(service.findByCustomerName("Ramesh"));
	    
	    System.out.println("Row updated"+service.updateEmail("ramesh@abc.com", 1));
	}

	
	@Bean
	Customer ram() {
		
		return Customer.builder().customerName("Suresh").email("rsur@abc.com").phoneNumber(40205024).build();
	}
}
