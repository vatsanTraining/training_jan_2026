package com.example.demo.repo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.example.demo.dto.Invoice;

public class InvoiceRepository {

	
	
	public List<Invoice> findAll(){
		
		
		Invoice invOne = new Invoice(101, LocalDate.of(2025, Month.MARCH, 6),"Ramesh" , 6000);

		Invoice invTwo = new Invoice(101, LocalDate.now(),"Ramesh" , 5000);

		Invoice invThree = new Invoice(103, LocalDate.of(2025, Month.FEBRUARY, 16),"Ramesh" , 7000);

		Invoice invFour = new Invoice(104, LocalDate.of(2025, Month.APRIL, 26),"Ramesh" , 2000);

		Invoice invFive= new Invoice(105, LocalDate.of(2025, Month.DECEMBER, 8),"Ramesh" , 4000);

		
		
		List<Invoice> list = List.of(invOne,invTwo,invThree,invFour,invFive);
		
		// The following line is added to demonstrate the feature of Unmodifiable collection
		
		//list.add(new Invoice(101,LocalDate.now(),"shiv",9000));
		
		return list;
	}
}
