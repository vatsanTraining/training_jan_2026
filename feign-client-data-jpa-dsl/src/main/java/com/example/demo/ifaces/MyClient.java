package com.example.demo.ifaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.CustomerResponse;

@FeignClient("DATA-JPA-DSL-MULTIPART")
public interface MyClient {

	@GetMapping("/api/v1/customers")
	List<CustomerResponse> findAll();
}
