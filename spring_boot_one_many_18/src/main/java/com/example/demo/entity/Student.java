package com.example.demo.entity;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tsc_student")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="roll_number")
	private int rollNumber;
	
	@Column(name="roll_number")
	private String studentName;
	
	@Column(name="roll_number")
	private String email;
	
	@Column(name="roll_number")
	private BigDecimal mark;
	
}