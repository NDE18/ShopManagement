package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.CategoryDto;
import com.nde.shopmanagement.entities.Category;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.CategoryRepository;
import com.nde.shopmanagement.services.CategoryService;
import com.nde.shopmanagement.validators.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()){
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("Category is not valid", ErrorCodes.CATEGORY_NOT_FOUND, errors);
        }
        return categoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null){
            log.error("ID Category is null {}", id);
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);

        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow(() -> new EntityNotFoundException(
                "No Category with ID = "+id+" found.",
                ErrorCodes.CATEGORY_NOT_FOUND
        ));
    }

    @Override
    public CategoryDto findItemCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("CODE item is null {}", code);
            return null;
        }
        Optional<Category> category = categoryRepository.findItemByCode(code);

        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow(() -> new EntityNotFoundException(
                "No item with ID = "+code+" found.",
                ErrorCodes.CATEGORY_NOT_FOUND
        ));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if(id == null){
            return;
        }
        categoryRepository.deleteById(id);
    }
}
