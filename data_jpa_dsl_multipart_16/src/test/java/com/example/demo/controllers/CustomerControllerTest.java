package com.example.demo.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;

import tools.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	
	   @Autowired
	    private MockMvc mockMvc;

	    @MockitoBean
	    private CustomerService service;

	    
	    
	    @Test
	    void getCustomerId_ShouldReturnCustomer_WhenIdExists() throws Exception {

	  Customer customer = new Customer(1L,"Ramesh",898899L,"ram@abc.com");

	  
	        when(service.findById(1L)).thenReturn(customer);

	        // Act & Assert
	        mockMvc.perform(get("/api/v1/customer/1"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.customerName").value("Ramesh"));
	    }

}
