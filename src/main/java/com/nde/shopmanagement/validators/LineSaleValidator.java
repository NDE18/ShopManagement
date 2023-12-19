package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.LineSaleDto;

import java.util.ArrayList;
import java.util.List;

public class LineSaleValidator {

    public static List<String> validate(LineSaleDto lineSaleDto){
        List<String> errors = new ArrayList<>();
        if(lineSaleDto == null){
            errors.add("Please select sale");
            errors.add("Please enter quantity");
            errors.add("Please enter unit price");
            return errors;
        }
        if(lineSaleDto.getSale() == null){
            errors.add("Please select sale");
        }
        if(lineSaleDto.getUnitPrice() == null){
            errors.add("Please enter unit price");
        }
        if(lineSaleDto.getQuantity() == null){
            errors.add("Please enter quantity");
        }
        return errors;
    }
}
