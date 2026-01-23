package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/info")
public class WelcomeController {

	
	
	
	@GetMapping
	public ResponseEntity<String> getMessage(){
		
		return ResponseEntity.ok("Secured Endpoint");
		
	}
}
