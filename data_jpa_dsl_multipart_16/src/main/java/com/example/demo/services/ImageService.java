package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerImage;
import com.example.demo.ifaces.CustomerRepository;
import com.example.demo.ifaces.ImageRepository;
import com.example.demo.model.CustomerDetails;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageService {
	
	
	private final ImageRepository repo;
	
	
	
	public CustomerImage save(String contentType, String fileName, byte[] image) {
		

		return this.repo.save(new CustomerImage(contentType, fileName, image));

		
	}



	public CustomerImage findById(int id) {
		return this.repo.findById(id).get();
	}
	

	
}


