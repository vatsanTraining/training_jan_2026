package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Invoice;
import com.example.demo.services.InvoiceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/invoices")

@AllArgsConstructor
public class InvoiceController {

	
	private InvoiceService service;
	
	
	@GetMapping
	List<Invoice> findAll(){
		
		return this.service.findAll();
	}
	
}
