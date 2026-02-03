package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;
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
	public ResponseEntity<List<Hotel>>  getHotel(){
		
		
		return ResponseEntity.ok(service.getHotel());
	}
	
	@PostMapping
	public ResponseEntity<Hotel> save(@RequestBody com.example.demo.entity.Hotel entity){
		
		return ResponseEntity.status(201).body(service.save(entity));
	}
}



