package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.dto.Invoice;
import com.example.demo.services.InvoiceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class SpringBootJdbc13Application {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootJdbc13Application.class);

	public static void main(String[] args) {
		
	    
		logger.info("application started");
		
		logger.info("--- SPLUNK IS READY. APPLICATION IS SENDING LOGS ---");
		
	ConfigurableApplicationContext	 ctx=SpringApplication.run(SpringBootJdbc13Application.class, args);
	
	
InvoiceService service =	ctx.getBean(InvoiceService.class);


//System.out.println(service.add(new Invoice(891, "Kamesh", LocalDate.now(), 19000)));

System.out.println(service.findByInvoiceNumber(103));

  service.findAll().forEach(System.out::println);

  
  // Force a pause here to let HEC flush the logs to Splunk
  try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} // Wait for 5 seconds
 // ctx.close();
  
	}

}
