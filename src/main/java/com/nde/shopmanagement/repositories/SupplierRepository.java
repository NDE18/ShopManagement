package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
