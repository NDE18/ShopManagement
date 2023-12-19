package com.nde.shopmanagement.services;

import com.nde.shopmanagement.dto.BusinessDto;

import java.util.List;

public interface BusinessService {
    BusinessDto save(BusinessDto businessDto);

    BusinessDto findById(Integer id);

    BusinessDto findCode(String itemCode);

    List<BusinessDto> findAll();

    void delete(Integer id);
}
