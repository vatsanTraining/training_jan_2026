package com.example.demo.entity;

import jakarta.persistence.Lob;

// Add Lombok Related annotation

// Add JPA related annotations
public class CustomerImage {

	
	//add a primary key field , contentType and fileName
	
	
	
	@Lob
	private byte[] imageRef;
}
