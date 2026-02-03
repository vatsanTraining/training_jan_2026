package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Hotel;

@Service
public class HotelService {

	
	private Hotel hotel;
	
	
	
	public HotelService(Hotel hotel) {
		super();
		this.hotel = hotel;
	}



	public Hotel getHotel() {
		
	   return this.hotel;
	}
}
