package com.nde.shopmanagement.services;

import com.nde.shopmanagement.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerDto customerDto);

    CustomerDto findById(Integer id);

    CustomerDto findByCode(String itemCode);

    List<CustomerDto> findAll();

    void delete(Integer id);
}
