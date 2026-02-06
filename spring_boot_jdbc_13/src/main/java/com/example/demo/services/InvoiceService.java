package com.example.demo.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.SpringBootJdbc13Application;
import com.example.demo.dto.Invoice;
import com.example.demo.ifaces.MyDao;

@Service
public class InvoiceService {

	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootJdbc13Application.class);

	private MyDao<Invoice> dao;

	public InvoiceService(MyDao<Invoice> dao) {
		super();
		this.dao = dao;
		logger.info("Service constructed");
	}
	
	public boolean add(Invoice inv) {
		return this.dao.add(inv);
	}
	
	public List<Invoice> findAll(){
		logger.info("Find All Called");
		return this.dao.findAll();
	}
	
	public Invoice findByInvoiceNumber(int invoiceNumber) {
		
		logger.info("Find All Called");

		return this.dao.findById(invoiceNumber);
		
	}
}
