package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Customer;
import com.example.demo.ifaces.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class TestCustomerService {
	
	
	@InjectMocks
	CustomerService service;
	
	@Mock
	CustomerRepository repo;
	
	@Test
	void testMethod() {
	
		when(repo.findById(1L)).thenReturn(Optional.of(new Customer(1L,"Ramesh", 9002232, "ram@abc.com")));
		
		Customer actual = service.findById(1L);
		
		Customer expected =new Customer(1L,"RAMESH", 9002232, "ram@abc.org");
		verify(repo,times(1)).findById(1L);
		
		assertEquals(expected, actual);
		
	}

}
