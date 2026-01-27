package com.example.demo.junit_testing_20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentService {

	List<String> names;
	
	
	
	public StudentService() {
		super();
		
		this.names= new ArrayList<>();
		
		this.names.add("Anand");
		this.names.add(null);
		this.names.add("Chandan");
		this.names.add("Charles");
		this.names.add("Shiv");
		
	}


	public String getMessage() {
		
		//return "Hello Chennai";
		return "Hello India";
	}
	
	
	public String assignGrade(double mark) throws RuntimeException{
		
		
		var grade ="A";
		
		if(mark>0 && mark<=60) {
			
			grade ="B";
		} 
		if(mark>60 && mark<=100) {
			grade ="C";
		}
		if(mark<0 || mark >100) {
		   throw new RuntimeException();
		}
		return grade;

	}
	
	public String getName(int idxPos) {
		
		return this.names.get(idxPos);
		
	}
	
}
