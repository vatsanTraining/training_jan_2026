package com.example.demo.services;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.example.demo.dto.Invoice;
import com.example.demo.repo.InvoiceRepository;

public class InvoiceService {

	
	private InvoiceRepository repo;

	public InvoiceService(InvoiceRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<Invoice> findAll(){
		
		return this.repo.findAll();
	}
	
	
	public Set<Invoice> getWithSet(){
		
		
		TreeSet<Invoice> set = new TreeSet<>(findAll());
		
		return set;
		
	}
}
