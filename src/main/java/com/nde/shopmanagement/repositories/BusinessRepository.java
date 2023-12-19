package com.nde.shopmanagement.repositories;

import com.nde.shopmanagement.entities.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Integer> {
}
