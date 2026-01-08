package com.example.demo;

import java.util.List;

import com.example.demo.dto.Invoice;
import com.example.demo.repo.InvoiceRepository;

public class Application {

	public static void main(String[] args) {

		
	
		var repo = new InvoiceRepository();
		
		List<Invoice> list = repo.findAll();
		
		
		list.forEach(System.out::println);
		
	}

}
