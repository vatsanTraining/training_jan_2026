package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Review;
import com.example.demo.ifaces.ReviewRepository;

@Service
public class ReviewService {

	
	private ReviewRepository repo;
	
	
	



	public ReviewService(ReviewRepository repo) {
		super();
		this.repo = repo;
	}






	public List<Review> getReview() {
		
	   return this.repo.findAll();
	}
}
