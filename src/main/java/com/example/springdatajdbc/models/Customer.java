package com.example.springdatajdbc.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Table("customers")
@Data
@Builder
public class Customer {
    @Id
    private Long customerId;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    //private Set<Account> accounts;
}
