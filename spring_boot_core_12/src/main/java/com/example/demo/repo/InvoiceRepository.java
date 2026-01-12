package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Invoice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Repository
@Data
public class InvoiceRepository {

	
	
	private Invoice invoice;
	
	private List<Invoice> invList;

	// if the field is collection spring can collate all them in to a collection Implementation
	public InvoiceRepository(List<Invoice> invList) {
		super();
		this.invList = invList;
	}
	

	// If more than one instance are available specify the one which you want with @Qulifier
//	public InvoiceRepository(@Qualifier("invoice") Invoice invoice) {
//		super();
//		this.invoice = invoice;
//	}
//	
	
	// If only one instance of Invoice is available use this approach
//	public InvoiceRepository(Invoice invoice) {
//		super();
//		this.invoice = invoice;
//	}
//	

	
	
	
}
