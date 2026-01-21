package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	
	
	@GetMapping(path = "/first")
	public String unSecured() {
		
		return "UNSECURED ENDPOINT";
	}
	
	@GetMapping(path = "/second")
	public String secured() {
		
		return "**** SECURED ENDPOINT ****";
	}
	
}
