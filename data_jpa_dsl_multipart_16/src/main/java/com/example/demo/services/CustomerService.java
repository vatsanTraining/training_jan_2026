package com.example.demo.services;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
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
	

	@Cacheable(value = "customerById",key = "#id")
	public Customer findById(Long id) {
		
		return this.repo.findById(id)
				.orElseThrow(()-> new RuntimeException("Element with Given Id Not Found"));
	}
	public List<Customer> findAll() {

		return this.repo.findAll();
		
	}
	
	public int  updateEmail(String revisedMail,long id){
		
		return this.repo.updateEmailById(revisedMail, id);
	}
	
	
	public Customer findByCustomerName(String name) {
		
		return this.repo.findByCustomerName(name);
	}

	
	public List<CustomerDetails> fetchDetails(){
		
		return this.repo.fetchCustomerDetails();
	}
	

	public void removeCustomer(Long id) {
		
		if(!this.repo.existsById(id)) {
			throw new RuntimeException("Element With given Id Not found");
		}
		this.repo.deleteById(id);

	}


	public Customer update(Customer entity) {
		return this.save(entity);
	}
}











