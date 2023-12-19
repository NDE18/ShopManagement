package com.nde.shopmanagement.services;


import com.nde.shopmanagement.dto.SupplierOrderDto;

import java.util.List;

public interface SupplierOrderService {

    SupplierOrderDto save(SupplierOrderDto supplierOrderDto);

    SupplierOrderDto findById(Integer id);

    SupplierOrderDto findByCode(String supplierOrderCode);

    List<SupplierOrderDto> findAll();

    void delete(Integer id);
}
