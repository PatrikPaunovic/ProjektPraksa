package com.example.demo.repository;

import com.example.demo.model.Invoice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("SELECT MAX(i.invoiceNumber) FROM Invoice i")
    Long findMaxInvoiceNumber();
    @EntityGraph(attributePaths = {"customer"})
    List<Invoice> findAll();
}