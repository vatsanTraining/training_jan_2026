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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/customers",produces = "application/json")


@AllArgsConstructor
public class CustomerController {

	
	private final CustomerService service;
	
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll(){
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(this.service.findAll());

	}
	
	@GetMapping(path = "/xml", produces = "application/xml")
	public ResponseEntity<List<Customer>> findAllAsXML(){
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(this.service.findAll());
	}
	

	@PostMapping
	@Operation(description = "Used to Persist to Data" ,summary = "Add One Customer Detail Resource")
	@ApiResponses(@ApiResponse(responseCode = "201",description = "Shows customer added successfully"))
	public ResponseEntity<Customer> save(@RequestBody Customer entity){
		
		Customer saved = this.service.save(entity);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(saved);
		
	}
	
//	@PostMapping
//	public Customer save(@RequestBody Customer entity){
//		
//		return this.service.save(entity);
//		
//		
//		
//	}
	
	@PutMapping
	public ResponseEntity<Customer> update(@RequestBody Customer entity){
		
		Customer updated = this.service.update(entity);
		
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(updated);
		
	}
	
	@PatchMapping(path ="/{id}/{revisedMail}",produces = "application/json")
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












