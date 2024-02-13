package com.example.springdatajdbc.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("beneficiaries")
@Data
@Builder
public class Beneficiary {
    @Id
    private Long beneficiaryId;
    private Long customerId; // Foreign key
    private String beneficiaryName;
    private String accountNumber;
    private LocalDateTime addedAt;

}

