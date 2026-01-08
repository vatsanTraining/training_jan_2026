package com.example.demo;

import java.util.List;

import com.example.demo.dto.Invoice;
import com.example.demo.repo.InvoiceRepository;
import com.example.demo.services.InvoiceService;

public class Application {

	public static void main(String[] args) {

		
	
		var repo = new InvoiceRepository();
		

		var service = new InvoiceService(repo);
		
		List<Invoice> list = service.findAll();
		
		System.out.println("====== List =========");
		
		list.forEach(System.out::println);
	
		
		System.out.println("*******  Set ********");
		
		service.getWithSet().forEach(System.out::println);
		
		
	}

}
