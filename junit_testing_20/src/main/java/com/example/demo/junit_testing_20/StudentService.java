package com.example.demo.junit_testing_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentService {

	List<String> names;
	
	static Set<Integer> marks;
	
	
	public StudentService() {
		super();
		
		this.names= new ArrayList<>();
		
		this.names.add("Anand");
		this.names.add("Basker");
		this.names.add("Chandan");
		this.names.add("Charles");
		this.names.add("Shiv");
		this.names.add("Zhir");
		
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
		   throw new RuntimeException("ERR-109");
		}
		return grade;

	}
	
	public List<String> getName() {
		
		return this.names;
		
	}
	
	private String concat(String ...strings) {
		
		
			
		    return String.join(":", strings);
		
	}

	

}
