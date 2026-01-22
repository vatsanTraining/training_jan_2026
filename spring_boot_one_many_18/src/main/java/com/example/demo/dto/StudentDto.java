package com.example.demo.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record StudentDto(
		
		@Positive(message = "Roll Number should be positive integer")
		int rollNumber,
		
		@NotBlank(message = "Student Name should contain atleast one character")
		String studentName,
		
		@Email(message = "Valid Email should be 8 to 30 chars length")
		@Size(min = 8 , max = 30)
		String email,
		
		@Max(value = 100,message = "maximum mark is 100")
		@Min(value = 0,message = "Minimum mark is 0")
		BigDecimal mark
		
		
		) {

}
