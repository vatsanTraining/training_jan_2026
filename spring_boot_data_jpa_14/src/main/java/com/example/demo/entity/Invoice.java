package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "invoice_jan_26")
public class Invoice {

	
	@Id
	@Column(name = "invoice_number")
	private int invoiceNumber;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "invoice_date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate invoiceDate;
	
	@Column(name = "amount")
	private double amount;
	
	
	
	
}
