package com.example.demo.ifaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.dto.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {

}

