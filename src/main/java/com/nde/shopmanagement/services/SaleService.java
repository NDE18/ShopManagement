package com.nde.shopmanagement.services;

import com.nde.shopmanagement.dto.SaleDto;
import com.nde.shopmanagement.dto.SupplierOrderDto;

import java.util.List;

public interface SaleService {

    SaleDto save(SaleDto saleDto);

    SaleDto findById(Integer id);

    SaleDto findByCode(String supplierOrderCode);

    List<SaleDto> findAll();

    void delete(Integer id);
}
