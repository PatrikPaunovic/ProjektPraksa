package com.example.demo.model;

import com.example.demo.constants.ColumnNames;
import com.example.demo.constants.TableNames;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = TableNames.INVOICE)
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ColumnNames.ID)
    private Long id;

    @Column(name = ColumnNames.INVOICE_NUMBER, length = 255)
    private String invoiceNumber;

    @Column(name = ColumnNames.AMOUNT, precision = 38, scale = 2)
    private BigDecimal amount;

    @Column(name = ColumnNames.DATE)
    private LocalDateTime date;

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    // Getters and Setters
}