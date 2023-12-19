package com.nde.shopmanagement.services;

import com.nde.shopmanagement.dto.CustomerOrderDto;

import java.util.List;

public interface CustomerOrderService {

    CustomerOrderDto save(CustomerOrderDto customerOrderDto);

    CustomerOrderDto findById(Integer id);

    CustomerOrderDto findByCode(String customerOrderCode);

    List<CustomerOrderDto> findAll();

    void delete(Integer id);
}
