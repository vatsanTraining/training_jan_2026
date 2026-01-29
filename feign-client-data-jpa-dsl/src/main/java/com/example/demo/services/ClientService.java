package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerResponse;
import com.example.demo.ifaces.MyClient;

@Service
public class ClientService {

	private  MyClient client;

	public ClientService(MyClient client) {
		super();
		this.client = client;
	}

	public List<CustomerResponse> findAll() {
		return client.findAll();
	}

	public String getPort() {
		return client.getPort();
	}

}
