package com.example.springdatajdbc.repositories;

import com.example.springdatajdbc.models.Transaction;
import org.springframework.data.repository.ListCrudRepository;

public interface TransactionRepository extends ListCrudRepository<Transaction, Long> {
}
