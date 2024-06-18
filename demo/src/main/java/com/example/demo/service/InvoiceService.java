package com.example.demo.service;

import com.example.demo.model.Invoice;
import java.util.List;

public interface InvoiceService {
    public Invoice saveInvoice(Invoice invoice);
    public List<Invoice> getAllInvoices();
    public Invoice getInvoiceById(Long id);
    public void deleteInvoice(Long id);

}
