package com.example.demo.dto;

import java.time.LocalDate;

public record Invoice(int invoiceNumber,LocalDate invoiceDate,String customerName, double amount) implements Comparable<Invoice> {

	@Override
	public int compareTo(Invoice o) {
		return Double.compare(amount, o.amount);
	}

}
