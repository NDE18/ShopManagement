package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.CustomerOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderLineRepository extends JpaRepository<CustomerOrderLine, Integer> {
}
