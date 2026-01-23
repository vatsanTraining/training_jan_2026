package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Customer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "Customer Management",version = "1.0"),
 servers = {@Server(url="http://localhost:5050/",description = "Local server"),
		 @Server(url="https://prod.example.com/",description = "Production server")})
public class DataJpaDslMultipart16Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(DataJpaDslMultipart16Application.class, args);
	
	   // CustomerService service = ctx.getBean(CustomerService.class);
	    
	    //Customer customer = ctx.getBean(Customer.class);
	    
//	    Customer saved=service.save(customer);
//	
//	    System.out.println("Saved Entity"+ saved);
	    
	  //  service.fetchDetails().forEach(System.out::println);
	    
	   // System.out.println(service.findByCustomerName("Ramesh"));
	    
	   // System.out.println("Row updated"+service.updateEmail("ramesh@abc.com", 1));
	    
	    
	    
//	    ImageService imgService = ctx.getBean(ImageService.class);
//	    
//	    
//	    ClassPathResource imageRef = new ClassPathResource("logo.jpeg");
//	    
//	    
//	       byte[] image=null;
//	       try(InputStream stream = imageRef.getInputStream()) {
//			
//	    	   image = stream.readAllBytes();
//	    	   
//	    	   imgService.save("logo","img/png", image);
//	    	   
//	    	   System.out.println("One Image Saved");
//	       }catch(Exception e) {
//	    	   e.printStackTrace();
//	       }

	}

	
	@Bean
	Customer ram() {
		
		return Customer.builder().customerName("Suresh").email("rsur@abc.com").phoneNumber(40205024).build();
	}
}
