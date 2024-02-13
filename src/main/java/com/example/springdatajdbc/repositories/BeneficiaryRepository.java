package com.example.springdatajdbc.repositories;

import com.example.springdatajdbc.models.Beneficiary;
import org.springframework.data.repository.ListCrudRepository;

public interface BeneficiaryRepository extends ListCrudRepository<Beneficiary, Long> {
}
