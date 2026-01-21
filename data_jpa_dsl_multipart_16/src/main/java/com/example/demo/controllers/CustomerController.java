package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/customers",produces = "application/json")


@AllArgsConstructor
public class CustomerController {

	
	private final CustomerService service;
	
	
	@GetMapping
	public List<Customer> findAll(){
		
		return this.service.findAll();
	}
	
	@GetMapping(path = "/xml", produces = "application/xml")
	public List<Customer> findAllAsXML(){
		
		return this.service.findAll();
	}
	

	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody Customer entity){
		
		Customer saved = this.service.save(entity);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(saved);
		
	}
	
	@PutMapping
	public ResponseEntity<Customer> update(@RequestBody Customer entity){
		
		Customer updated = this.service.update(entity);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(updated);
		
	}
	
	@PatchMapping(path ="/{id}",produces = "application/json")
	public ResponseEntity<String> updateEmil(@PathVariable long id, @PathVariable String revisedMail) {
		
		return ResponseEntity.ok().body(service.updateEmail(revisedMail,id) +"=Row Updated");
	}
	
	@GetMapping(path ="/{id}",produces = "application/json")
	public ResponseEntity<Customer> findById(@PathVariable long id) {
		
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	
	
	@DeleteMapping(path = "/{id}")
public ResponseEntity<Void> deleteById(@PathVariable long id) {
		
		this.service.removeCustomer(id);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(null);
	}
	
}












