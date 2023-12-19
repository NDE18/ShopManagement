package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.SupplierOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderLineRepository extends JpaRepository<SupplierOrderLine, Integer> {
}
