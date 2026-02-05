package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Review;

@Service
public class ReviewService {

	
	private Review review;
	
	
	
	public ReviewService(Review review) {
		super();
		this.review = review;
	}



	public Review getReview() {
		
	   return this.review;
	}
}
