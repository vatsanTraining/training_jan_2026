package com.example.demo.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity
@Table(name = "mycustomers")
public class Customer {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "customer_name", length = 20,unique = true)
	private String customerName;
	
	@Column(name = "phone_number")
	private long phoneNumber;
	
	@Column(name = "email", length = 20)
	private String email;
	
}
