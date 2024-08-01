package com.example.springdatajdbc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("accounts")
@Data
@Builder
@AllArgsConstructor
public class Account {
    @Id
    private Long accountId;
    private Long customerId; // Foreign key
    private String accountNumber;
    private BigDecimal balance;
    private String accountType;
    private LocalDateTime createdAt;
    //Set<Transaction> transactions;
}

