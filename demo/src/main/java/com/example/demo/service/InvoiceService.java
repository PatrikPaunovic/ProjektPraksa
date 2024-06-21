package com.example.demo.service;

import com.example.demo.model.Invoice;
import java.util.List;

public interface InvoiceService {

    public List<Invoice> getAllInvoices();
    public Invoice getInvoiceById(Long id);

    Invoice createInvoice(Invoice invoiceEntity);

    Long getInvoiceNumber();

    public void deleteInvoice(Long id);

    List<Invoice> getInvoicesByUsername(String username);
}
