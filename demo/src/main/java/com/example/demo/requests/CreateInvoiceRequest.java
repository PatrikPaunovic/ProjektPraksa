package com.example.demo.requests;

import lombok.Data;
import java.util.Map;

@Data
public class CreateInvoiceRequest {
    private Long paymentTypeId;
    private Map<Long, Long> products;
    private String customerUsername;
}