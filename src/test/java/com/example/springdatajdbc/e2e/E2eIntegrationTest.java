package com.example.springdatajdbc.e2e;

import com.example.springdatajdbc.models.Account;
import com.example.springdatajdbc.models.Customer;
import com.example.springdatajdbc.repositories.AccountRepository;
import com.example.springdatajdbc.repositories.CustomerRepository;
import org.assertj.core.api.Assertions;
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
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
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
    void customerAccountRelationshipTest() {
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
                .accountNumber("1211")
                .balance(BigDecimal.valueOf(1000))
                .accountType("SAVINGS")
                .createdAt(LocalDateTime.now())
                .build());
        accountRepository.save(Account.builder()
                .customerId(customer.getCustomerId())
                .accountNumber("1212")
                .balance(BigDecimal.valueOf(2000))
                .accountType("SAVINGS")
                .createdAt(LocalDateTime.now())
                .build());

        System.out.println(customerRepository.findAll());
        System.out.println(accountRepository.findAll());

        assertThat(customerRepository.findAll()).size().isGreaterThan(0);
        assertThat(accountRepository.findAll()).size().isGreaterThan(0);
    }

}
