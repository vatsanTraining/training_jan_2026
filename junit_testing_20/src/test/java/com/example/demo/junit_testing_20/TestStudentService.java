package com.example.demo.junit_testing_20;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class TestStudentService {

	
	private static List<String> nameList;
	
	private StudentService service;
	
	@BeforeAll
	static void init() {
		
		nameList = List.of("Ramesh","Suresh","Magesh");
		
		System.out.println("Before All Called ========");
		
	}
	
	@BeforeEach
	void  setUp(TestInfo info) {
		
		 service = new StudentService();

		System.out.println("BEFORE EACH Called @@@@@@=>"+ info.getTestMethod().get().getName() + "Called");

	}
	
	@Test
	@DisplayName("Test Get Message Method returns a string Hello India")
	void testGetMessage() {
		
		
		String actual = service.getMessage();
		
		String expected ="Hello India";
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	@DisplayName("Testing the various Requirements of assign grade")
	void testAssignGrade() {
		
		   String actual= service.assignGrade(60);
		   
		   assertEquals("B", actual);
		    
		
	}
	@AfterAll
	static void cleanUp() {
		
		nameList= null;
		
		System.out.println("AFTER  All Called ******");

	}
	
	@AfterEach
	void  tearDown(TestInfo info) {
		
		System.out.println("AFTER EACH Called @@@@@@=>"+ info.getTestMethod().get().getName() + "Called");

	}
}
