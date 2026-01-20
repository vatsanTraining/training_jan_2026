package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.ifaces.CustomerRepository;
import com.example.demo.model.CustomerDetails;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
	
	private final CustomerRepository repo;
	
	
	

	public Customer save(Customer customer) {

		return this.repo.save(customer);
		 
	}
	

	public List<Customer> findAll() {

		return this.repo.findAll();
		
	}
	
	public int  updateEmail(String revisedMail,int id){
		
		return this.repo.updateEmailById(revisedMail, id);
	}
	
	
	public Customer findByCustomerName(String name) {
		
		return this.repo.findByCustomerName(name);
	}

	
	public List<CustomerDetails> fetchDetails(){
		
		return this.repo.fetchCustomerDetails();
	}
	

}
