package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String designation;

    private List<ItemDto> items;

    public static CategoryDto fromEntity(Category category){
        if(category == null){
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .designation(category.getDesignation())
                .code(category.getCode())
                .build();
    }
    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null){
            return null;
        }
        return Category.builder()
                .id(categoryDto.getId())
                .code(categoryDto.getCode())
                .designation(categoryDto.getDesignation())
                .build();
    }
}
