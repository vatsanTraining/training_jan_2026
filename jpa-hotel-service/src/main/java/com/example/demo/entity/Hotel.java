package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "hotel")
public class Hotel {

	
	@Id
	@Column(name = "hotelNumber")
	private int hotelNumber;
	

	@Column(name = "hotelName")
	private String hotelName;
	
	@Column(name = "city")
	private String city;

	@Column(name = "pincode")
	private long pincode;
	
	
}
