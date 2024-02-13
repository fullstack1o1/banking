package com.example.springdatajdbc.repositories;

import com.example.springdatajdbc.models.Session;
import org.springframework.data.repository.ListCrudRepository;

public interface SessionRepository extends ListCrudRepository<Session, Long> {
}
