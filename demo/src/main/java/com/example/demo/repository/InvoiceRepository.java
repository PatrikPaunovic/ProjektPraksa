package com.example.demo.repository;

import com.example.demo.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("SELECT MAX(ie.invoiceNumber) FROM InvoiceEntity ie")
    Long findMaxInvoiceNumber();

    @Query("SELECT ie FROM Invoice ie WHERE ie.customerUsername = ?1")
    List<Invoice> findInvoicesByUsername(String username);
}