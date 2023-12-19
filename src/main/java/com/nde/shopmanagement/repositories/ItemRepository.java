package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.Item;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findItemByCodeItem(String itemCode);
}
