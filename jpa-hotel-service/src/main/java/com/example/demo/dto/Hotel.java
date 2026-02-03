package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

	
	private int hotelNumber;
	private String hotelName;
	private String city;
	private long pincode;
	
	
}
