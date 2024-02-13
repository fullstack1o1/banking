package com.example.springdatajdbc.repositories;

import com.example.springdatajdbc.models.Account;
import org.springframework.data.repository.ListCrudRepository;

public interface AccountRepository extends ListCrudRepository<Account, Long> {
}
