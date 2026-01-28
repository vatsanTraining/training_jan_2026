package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;

@SpringBootTest
class DataJpaDslMultipart16ApplicationTests {

	 @Autowired
		CustomerService service;
		
		@Test
		void testMethod() {
		
			
			Customer actual = service.findById(1L);
			
			Customer expected =new Customer(1L,"Ramesh", 9002232, "ram@abc.com");
			
			assertEquals(expected, actual);
			
		}

}
