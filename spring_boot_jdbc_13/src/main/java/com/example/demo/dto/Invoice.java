package com.example.demo.dto;

import java.time.LocalDate;

public record Invoice(int invoiceNumber,String customerName,LocalDate invoiceDate,double amount) {

}

