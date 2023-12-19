package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.SaleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SaleValidator {

    public static List<String> validate(SaleDto saleDto){
        List<String> errors = new ArrayList<>();
        if(saleDto == null){
            errors.add("Please select sale date");
            errors.add("Please enter code");
            errors.add("Please enter comment");
        }
        if(saleDto.getSaleDate() == null){
            errors.add("Please select sale date");
        }
        if(!StringUtils.hasLength(saleDto.getCode())){
            errors.add("Please enter code");
        }
        if(!StringUtils.hasLength(saleDto.getComment())){
            errors.add("Please enter comment");
        }
        return errors;
    }
}
