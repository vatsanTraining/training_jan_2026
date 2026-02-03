package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Hotel;
import com.example.demo.services.HotelService;

@RestController
@RequestMapping(path = "/api/v1/hotels")
public class HotelController {

	
	private HotelService service;

	public HotelController(HotelService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public ResponseEntity<Hotel>  getHotel(){
		
		
		return ResponseEntity.ok(service.getHotel());
	}
}



