package com.example.springdatajdbc.e2e;

import com.example.springdatajdbc.models.Account;
import com.example.springdatajdbc.models.Customer;
import com.example.springdatajdbc.repositories.AccountRepository;
import com.example.springdatajdbc.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
public class E2eIntegrationTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Container
    @ServiceConnection
    static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(PostgreSQLContainer.IMAGE)
            .withInitScript("schema.sql");

    @Test
    void customerEntityTest() {
        var customer = customerRepository.save(Customer.builder()
                .username("testuser")
                .password("testpassword")
                .email("")
                .fullName("Test User")
                .dateOfBirth(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .build());

        accountRepository.save(Account.builder()
                .customerId(customer.getCustomerId())
                .accountNumber("1234567890")
                .balance(BigDecimal.valueOf(1000))
                .accountType("SAVINGS")
                .createdAt(LocalDateTime.now())
                .build());

        assertTrue(accountRepository.findAll().size() > 0);
    }

}
