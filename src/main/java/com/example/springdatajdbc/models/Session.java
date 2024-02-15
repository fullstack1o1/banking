package com.example.springdatajdbc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("sessions")
@Data
@Builder
@AllArgsConstructor
public class Session {
    @Id
    private Long sessionId;
    private Long customerId; // Foreign key
    private String sessionToken;
    private LocalDateTime createdAt;

}

