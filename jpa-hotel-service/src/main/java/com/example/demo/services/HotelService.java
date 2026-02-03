package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.ifaces.HotelRepository;

@Service
public class HotelService {

	
	private HotelRepository repo;
	
	
	
	public HotelService(HotelRepository repo) {
		super();
		this.repo = repo;
	}


	public List<Hotel> getHotel() {
		
	   return this.repo.findAll();
	}
	
	public Hotel save(Hotel entity) {
		
		return this.repo.save(entity);
	}
}
