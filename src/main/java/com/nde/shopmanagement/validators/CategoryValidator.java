package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if(categoryDto == null){
            errors.add("Please enter code");
            errors.add("Please enter designation");
            return errors;
        }
        if(!StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Please enter code");
        }
        if(!StringUtils.hasLength(categoryDto.getDesignation())){
            errors.add("Please enter designation");
        }
        return errors;
    }
}
