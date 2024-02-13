package com.example.springdatajdbc.repositories;

import com.example.springdatajdbc.models.Customer;
import org.springframework.data.repository.ListCrudRepository;

public interface CustomerRepository extends ListCrudRepository<Customer, Long> {
}
