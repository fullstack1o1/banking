package com.example.springdatajdbc.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("transactions")
@Data
@Builder
public class Transaction {
    @Id
    private Long transactionId;
    private Long accountId; // Foreign key
    private String transactionType;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

}

