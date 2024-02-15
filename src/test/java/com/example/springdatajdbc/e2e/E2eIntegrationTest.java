package com.example.springdatajdbc.e2e;

import com.example.springdatajdbc.models.Account;
import com.example.springdatajdbc.models.Beneficiary;
import com.example.springdatajdbc.models.Customer;
import com.example.springdatajdbc.models.Session;
import com.example.springdatajdbc.repositories.AccountRepository;
import com.example.springdatajdbc.repositories.BeneficiaryRepository;
import com.example.springdatajdbc.repositories.CustomerRepository;
import com.example.springdatajdbc.repositories.SessionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
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

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;


    @Container
    @ServiceConnection
    static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(PostgreSQLContainer.IMAGE)
            .withInitScript("schema.sql");

    @Test
    void customerEntityRelationshipTest() {
        //approach 1
        var customer = customerRepository.save(Customer.builder()
                .username("testuser")
                .password("testpassword")
                .email("")
                .fullName("Test User")
                .dateOfBirth(LocalDate.now())
                .createdAt(LocalDateTime.now())
                .accounts(
                        Set.of(
                            Account.builder()
                            .accountNumber("1211")
                            .balance(BigDecimal.valueOf(1000))
                            .accountType("SAVINGS")
                            .createdAt(LocalDateTime.now())
                            .build(),
                            Account.builder()
                            .accountNumber("1212")
                            .balance(BigDecimal.valueOf(2000))
                            .accountType("SAVINGS")
                            .createdAt(LocalDateTime.now())
                            .build()
                        )
                )
                .session(Session.builder().sessionToken("FAKE").build())
                .beneficiaries(
                        Set.of(
                                Beneficiary.builder().beneficiaryName("B1").accountNumber("1").build(),
                                Beneficiary.builder().beneficiaryName("B2").accountNumber("2").build()
                        )
                )
                .build());
        /*

        //approach 2
        var account1 = Account.builder()
                .customerId(customer.getCustomerId())
                .accountNumber("1211")
                .balance(BigDecimal.valueOf(1000))
                .accountType("SAVINGS")
                .createdAt(LocalDateTime.now())
                .build();
        var account2 = Account.builder()
                .customerId(customer.getCustomerId())
                .accountNumber("1212")
                .balance(BigDecimal.valueOf(2000))
                .accountType("SAVINGS")
                .createdAt(LocalDateTime.now())
                .build();
        accountRepository.save(account1);
        accountRepository.save(account2);
        */

        System.out.println(customerRepository.findAll());
        System.out.println(accountRepository.findAll());
        System.out.println(sessionRepository.findAll());
        System.out.println(beneficiaryRepository.findAll());

        assertTrue(customerRepository.findById(customer.getCustomerId()).isPresent());
        assertThat(customerRepository.findAll()).size().isGreaterThan(0);
        assertThat(accountRepository.findAll()).size().isGreaterThan(0);
        assertThat(sessionRepository.findAll()).size().isGreaterThan(0);
        assertThat(beneficiaryRepository.findAll()).size().isGreaterThan(0);
    }

}
