package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Integer> {

    Optional<SupplierOrder> findByCode(String code);
}
