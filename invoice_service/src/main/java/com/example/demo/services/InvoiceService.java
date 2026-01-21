package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.InvoiceDto;
import com.example.demo.entity.Invoice;
import com.example.demo.repos.InvoiceRepository;
import com.example.demo.utils.InvoiceMapper;

@Service
public class InvoiceService {

	
	private InvoiceRepository repo;
	private InvoiceMapper mapper;

	public InvoiceService(InvoiceRepository repo,InvoiceMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		
		System.out.println(this.repo.getClass().getName());
	}
	
	
	public List<InvoiceDto> findAll(){
		
		return this.repo.findAll().stream().map(e-> mapper.toDto(e)).collect(Collectors.toList());
		 
	}
	
	
	public InvoiceDto save(InvoiceDto dto) {
		
		Invoice saved =  this.repo.save(mapper.toEntity(dto));
		
		return mapper.toDto(saved);
	}
	
	//deleteById, update and findByid 
	// and use the them rest controller and test with postman
	
}
