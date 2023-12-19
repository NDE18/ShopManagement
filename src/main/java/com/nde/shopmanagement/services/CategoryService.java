package com.nde.shopmanagement.services;

import com.nde.shopmanagement.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findItemCode(String itemCode);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
