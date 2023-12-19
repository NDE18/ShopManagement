package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    Optional<CustomerOrder> findByCode(String code);
}
