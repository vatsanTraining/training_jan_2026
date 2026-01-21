package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.InvoiceDto;
import com.example.demo.services.InvoiceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/invoices")

@AllArgsConstructor
public class InvoiceController {

	
	private InvoiceService service;
	
	
	@GetMapping
	List<InvoiceDto> findAll(){
		
		return this.service.findAll();
	}
	
	@GetMapping(path = "/{id}")
	List<InvoiceDto> findById(@PathVariable("id") int id){
		
		return this.service.findAll();
	}
	
	@PostMapping
	ResponseEntity<InvoiceDto> save(@RequestBody InvoiceDto dto){
		
		InvoiceDto saved =service.save(dto);
		       
		URI location=
		           ServletUriComponentsBuilder
		          .fromCurrentRequest()
		         .path("/{id}")
		          .buildAndExpand(saved.invoiceNumber())
		          .toUri();  

		return ResponseEntity.created(location).body(saved);
		
		
	}
}
