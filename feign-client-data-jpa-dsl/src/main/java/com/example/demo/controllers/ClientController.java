package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerResponse;
import com.example.demo.ifaces.MyClient;

@RestController
public class ClientController {

	private  MyClient client;

	public ClientController(MyClient client) {
		super();
		this.client = client;
	}
	
	@GetMapping("/api/v1/clients")
	public ResponseEntity<List<CustomerResponse>> findAll(){
		
		return ResponseEntity.ok().body(this.client.findAll());
	}
}
