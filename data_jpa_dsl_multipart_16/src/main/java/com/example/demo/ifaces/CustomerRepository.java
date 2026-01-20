package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Customer;
import com.example.demo.model.CustomerDetails;

import jakarta.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
	//DSL Query

	//Customer findByCustomerNam(String srchString);

	Customer findByCustomerName(String srchString);
	
	// Native Query with Projection observe table name and column names
	
	@Query(value = "select customer_name,phone_number from mycustomers",nativeQuery = true)
	List<CustomerDetails> fetchCustomerDetails();
	
	
	// JPA and a Modifying Query using DML using JPQL
	// Observe the ClassName and field Name
	
	@Modifying
	@Transactional
	@Query(value = "update Customer set email =:revised where customerId=:custId")
	int  updateEmailById(@Param("revised") String email,@Param("custId") int custId);
	
	
	
}
