package com.example.demo;

import java.util.List;
import java.util.function.Predicate;

import com.example.demo.dto.Invoice;
import com.example.demo.model.AutoPolicy;
import com.example.demo.model.InsurancePolicy;
import com.example.demo.repo.InvoiceRepository;
import com.example.demo.services.InvoiceService;

public class Application {

	
public static void recordDemo() {
		
		var repo = new InvoiceRepository();
		

		var service = new InvoiceService(repo);
		
		List<Invoice> list = service.findAll();
		
		System.out.println("====== List =========");
		
		list.forEach(System.out::println);
	
		
		System.out.println("*******  Set ********");
		
		service.getWithSet().forEach(System.out::println);
		
		
		System.out.println("######  Take While ######");
		
		service.getWithSet().stream().takeWhile(e -> e.amount()<7000).forEach(System.out::println);

//		System.out.println("Using List");
//		list.stream().takeWhile(e -> e.amount()<5000).forEach(System.out::println);
//		
        System.out.println("&&&&&& Drop While &&&&&&&");
		
		service.getWithSet().stream().dropWhile(e -> e.amount()<5000).forEach(System.out::println);

		
	}

	public static void main(String[] args) {

	
		recordDemo();
		
	
		InsurancePolicy policy = new AutoPolicy();
		
		System.out.println(policy.calculatePremium());
		
		Predicate<Integer> checkAge = (age) -> age>18;
		
		
		System.out.println("is Age Greater Than 18 =>" +checkAge.test(25));
		
		System.out.println(checkAge.getClass().getName());
		
		String invoiceAsJson = """ 
				
				{
				   "invoiceNumber":101,
				   "customerName":"ramesh",
				   "InvoiceDate":2024-10-10,
				   "amount":5000
				}
				
				""";
		
		
		System.out.println(invoiceAsJson);
	}

	
}
