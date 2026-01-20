package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
