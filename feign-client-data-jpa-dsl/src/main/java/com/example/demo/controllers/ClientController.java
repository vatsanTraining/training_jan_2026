package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerResponse;
import com.example.demo.ifaces.MyClient;
import com.example.demo.services.ClientService;

@RestController
public class ClientController {

	private  ClientService service;

	public ClientController(ClientService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/api/v1/clients")
	public ResponseEntity<List<CustomerResponse>> findAll(){
		
		return ResponseEntity.ok().body(this.service.findAll());
	}
	
	@GetMapping("/api/v1/ports")
	public ResponseEntity<String> getPort(){
		
		return ResponseEntity.ok().body(this.service.getPort());
	}
	
}
