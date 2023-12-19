package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCode(String code);
}
