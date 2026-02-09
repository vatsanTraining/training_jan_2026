package com.example.demo;

public class StudentService {

	
	public String  assignGrade(double mark) {
		
		System.out.println("First Line");
		
		System.out.println("Second line");
		
		return mark>80.00?"A":"B";
	}
}
