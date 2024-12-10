package com.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
