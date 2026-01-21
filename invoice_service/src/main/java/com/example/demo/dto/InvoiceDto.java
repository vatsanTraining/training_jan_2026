package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.Address;
import com.example.demo.utils.Status;

public record InvoiceDto(
		Integer invoiceNumber,
		String customerName,
		LocalDate invoiceDate,
		Status status,
		double amount,
		Address billingAddress,
		Address shippingAddress) {

	public InvoiceDto(Integer i, String string, LocalDate now, int j, Status generated, Address billing, Address shipping) {
      this(i, string, now, generated, j, billing, shipping);
	}

}
