package com.example.springdatajdbc.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("accounts")
@Data
@Builder
public class Account {
    @Id
    private Long accountId;
    private Long customerId; // Foreign key
    private String accountNumber;
    private BigDecimal balance;
    private String accountType;
    private LocalDateTime createdAt;
//    @MappedCollection(idColumn = "customer_id")
//    @Transient
//    private Customer customer;

}

