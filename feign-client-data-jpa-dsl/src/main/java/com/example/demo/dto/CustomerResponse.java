package com.example.demo.dto;


public record CustomerResponse(	
		long customerId,
		String customerName,
		long phoneNumber,
		String email) {}
