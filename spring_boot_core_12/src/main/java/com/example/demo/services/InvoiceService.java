package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice;

@Service
public class InvoiceService {

	
	public double calculateDiscount(Invoice invoice) {
		
		
		return invoice.getAmount()>5000?0.10:0.5;
		
		
	}
	
}
