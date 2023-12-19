package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findItemByCode(String code);
}
