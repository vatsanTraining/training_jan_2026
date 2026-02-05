package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Review;
import com.example.demo.services.ReviewService;

@RestController
@RequestMapping(path = "/api/v1/reviews")
public class ReviewController {

	
	private ReviewService service;

	public ReviewController(ReviewService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public ResponseEntity<Review>  getReview(){
		
		
		return ResponseEntity.ok(service.getReview());
	}
}



