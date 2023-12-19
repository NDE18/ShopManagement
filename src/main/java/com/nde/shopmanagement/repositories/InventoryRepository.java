package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
