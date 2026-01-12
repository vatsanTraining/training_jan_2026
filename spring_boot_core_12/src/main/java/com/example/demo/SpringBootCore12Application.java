package com.example.demo;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Invoice;
import com.example.demo.repo.InvoiceRepository;
import com.example.demo.services.InvoiceService;

@SpringBootApplication
public class SpringBootCore12Application {

	public static void main(String[] args) {
	
		ConfigurableApplicationContext	ctx=SpringApplication.run(SpringBootCore12Application.class, args);
	
	
		
		//ConfigurableApplicationContext	ctx=new SpringApplicationBuilder(SpringBootCore12Application.class).run(args);
		

//		ConfigurableApplicationContext	ctx=new SpringApplicationBuilder(PrimarySource.class)
//				       .bannerMode(Mode.OFF)
//				       .web(WebApplicationType.NONE)
//				       .run(args);


		
	InvoiceService service = ctx.getBean(InvoiceService.class);
	
	
	//var invoice = ctx.getBean("invoiceTwo",Invoice.class);

	var invoice = ctx.getBean(Invoice.class);

	 System.out.println(" expected "+invoice);

	 var discount = service.calculateDiscount(invoice);
	 
	 System.out.println("Discount Amount :=>"+ discount*invoice.getAmount());
	 
	 var repo = ctx.getBean(InvoiceRepository.class);
	 
	 System.out.println(" expected "+repo.getInvoice());
	 
	 
	 repo.getInvList().forEach(System.out::println);

	 
	 System.out.println("Service *********"+service.getAuthor());
	 ctx.close();
	}

	
	
}
