package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    Optional<Sale> findByCode(String code);
}
