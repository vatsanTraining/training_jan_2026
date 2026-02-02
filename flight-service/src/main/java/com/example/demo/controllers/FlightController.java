package com.example.demo.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Service
class FlightService{
	
	private HashMap<String, String> details;
	
	public FlightService() {
		
		this.details = new HashMap<>();
		details.put("MAS", "indigo,vistara");
		details.put("SBC", "AirIndia,AirAsia");
		
	}
	public String getFlights(String city) {
		
		return details.get(city);
	}
}

@RestController
@RequestMapping("/api/v1")
public class FlightController {

	
	private FlightService service ;
	
	public FlightController(FlightService service) {
		
		this.service = service;
	}
	
	@GetMapping(path = "/flights/{city}")
	public ResponseEntity<String> getFlight(@PathVariable String city) throws InterruptedException{
		
		
		return ResponseEntity.ok(service.getFlights(city));
		
	}
	
	private int counter = 0;

	@GetMapping(path = "/info/{city}")
	public ResponseEntity<String> getMessageByRetry(@PathVariable String city) {
	    counter++;

	    System.out.println("Attempt number: " + counter);
	    if (counter <= 3) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Temporary Failure");
	    }

	    counter = 0; 
	    return ResponseEntity.ok("Flights:=> " + service.getFlights(city));
	}

	
}
