package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Invoice;
import com.example.demo.repos.InvoiceRepository;

@Service
public class InvoiceService {

	
	private InvoiceRepository repo;

	public InvoiceService(InvoiceRepository repo) {
		super();
		this.repo = repo;
		
		System.out.println(this.repo.getClass().getName());
	}
	
	
	public List<Invoice> findAll(){
		
		
		return this.repo.findAll();
	}
	
	
	public Invoice save(Invoice entity) {
		
		return this.repo.save(entity);
	}
}
