package com.nde.shopmanagement.services;


import com.nde.shopmanagement.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    SupplierDto save(SupplierDto supplierDto);

    SupplierDto findById(Integer id);

    SupplierDto findSupplierCode(String itemCode);

    List<SupplierDto> findAll();

    void delete(Integer id);
}
