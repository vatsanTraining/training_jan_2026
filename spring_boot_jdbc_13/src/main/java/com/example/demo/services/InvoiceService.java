package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Invoice;
import com.example.demo.ifaces.MyDao;

@Service
public class InvoiceService {

	
	private MyDao<Invoice> dao;

	public InvoiceService(MyDao<Invoice> dao) {
		super();
		this.dao = dao;
	}
	
	
	public List<Invoice> findAll(){
		
		return this.dao.findAll();
	}
	
	public Invoice findByInvoiceNumber(int invoiceNumber) {
		
		return this.dao.findById(invoiceNumber);
		
	}
}
