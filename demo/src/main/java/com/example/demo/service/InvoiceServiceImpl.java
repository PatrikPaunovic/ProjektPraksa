package com.example.demo.service;

import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
public class InvoiceServiceImpl {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice createInvoice(Invoice invoiceEntity) {
        log.info("Creating invoice with invoice number: {}", invoiceEntity.getInvoiceNumber());
        return invoiceRepository.save(invoiceEntity);
    }

    @Override
    public Long getInvoiceNumber() {
        log.info("Getting next invoice number");
        return invoiceRepository.findMaxInvoiceNumber() + 1;
    }

    @Override
    public void deleteInvoice(Long id) {
        log.info("Deleting invoice with id: {}", id);
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        log.info("Getting all invoices");
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        log.info("Getting invoice by id: {}", id);
        return invoiceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invoice with id: " + id + " does not exist"));
    }

    @Override
    public List<Invoice> getInvoicesByUsername(String username) {
        return invoiceRepository.findInvoicesByUsername(username);
    }
}
