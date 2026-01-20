package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.demo.model.Address;
import com.example.demo.utils.Auditable;
import com.example.demo.utils.Status;

import jakarta.annotation.Generated;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumeratedValue;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Invoice extends Auditable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invoice_number")
	private int invoiceNumber;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "invoice_date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate invoiceDate;
	
	@Column(name = "amount")
	private double amount;
	

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "lineOne",column = @Column(name="bill_addr_lineOne")),
			@AttributeOverride(name="lineTwo",column = @Column(name="bill_addr_lineTwo")),
			@AttributeOverride(name="city",column = @Column(name="bill_addr_city")),
			@AttributeOverride(name="pincode",column = @Column(name="bill_addr_pincode")),
			
	})
	private Address billingAddress;
	
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "lineOne",column = @Column(name="ship_addr_lineOne")),
			@AttributeOverride(name="lineTwo",column = @Column(name="ship_addr_lineTwo")),
			@AttributeOverride(name="city",column = @Column(name="ship_addr_city")),
			@AttributeOverride(name="pincode",column = @Column(name="ship_addr_pincode")),
			
	})
	private Address shippingAddress;
	
	
}
