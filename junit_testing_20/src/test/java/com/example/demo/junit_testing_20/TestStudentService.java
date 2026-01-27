package com.example.demo.junit_testing_20;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TestStudentService {

	
	private static List<String> nameList;
	
	private StudentService service;
	
	@BeforeAll
	static void init() {
		
		nameList = List.of("Ramesh","Suresh","Magesh");
		
		System.out.println("Before All Called ========");
		
		StudentService.marks=new HashSet<>();
		
		StudentService.marks.add(50);
		StudentService.marks.add(60);
		StudentService.marks.add(70);
		
		
		
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
	
private String concat(String ...strings) {
		
		StringBuffer buffer = new StringBuffer();
		
		for(String eachString :strings) {
			
			buffer.append(eachString);
		}
		
		return buffer.toString();
	}
	@Test
	@DisplayName("Test Private Method Not Recommended Only if no other options are availabe")
	void testPrivateMethod() throws Exception{
		
		Method privateMethod =service.getClass().getDeclaredMethod("concat", String[].class);
		
		privateMethod.setAccessible(true);
		
	    String[] args = {"ramesh", "suresh"};

		
		String actual =(String)privateMethod.invoke(service,(Object)args);
		
		assertEquals("ramesh,suresh", actual);
		
		
		
	}
	
	@Test
	@DisplayName("Test Get Message Method other features using Java 8 ")
	void testGetMessageOtherFeatures() {
		
		
		assertAll("Test Multiple",
				() ->{
				 assertEquals("B" ,service.assignGrade(50))	;
				},
				() ->{
				var exception=	 assertThrows(RuntimeException.class, ()-> service.assignGrade(-20));

				      assertEquals("ERR-109", exception.getMessage());
				},
				()->{
				}
				);
		
	}
	
	
	@Test
	@Disabled
	void dummyTest() {
		
		fail("Not Yet implemented");
	}

	@ParameterizedTest
	@ValueSource(ints = {1,3,5})
	@DisplayName("Elmenents should not be null in odd positions")
	void testGetNameMethod(int idxPos) {
		
		assertNotNull(service.getName().get(idxPos));
	}

	@RepeatedTest(2)
	@DisplayName("Marks should not accept a duplicate value since its a set")
	void testDoesNotAcceptDuplicate() {
		
	assertEquals(true, StudentService.marks.add(78));	 ;
		
		
	}
	
	@Test
	@DisplayName("Testing the various Requirements of assign grade")
	void testAssignGrade()  {
		
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
