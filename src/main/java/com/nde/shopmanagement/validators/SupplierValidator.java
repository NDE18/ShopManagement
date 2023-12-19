package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.SupplierDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SupplierValidator {

    public static List<String> validate(SupplierDto supplierDto){
        List<String> errors = new ArrayList<>();

        if(supplierDto == null){
            errors.add("Please enter lastname");
            errors.add("Please enter firstname");
            errors.add("Please enter password");
            errors.add("Please enter email");
            return errors;
        }
        if(!StringUtils.hasLength(supplierDto.getLastName())){
            errors.add("Please enter lastname");
        }
        if(!StringUtils.hasLength(supplierDto.getFirstName())){
            errors.add("Please enter firstname");
        }
        if(!StringUtils.hasLength(supplierDto.getEmail())){
            errors.add("Please enter email");
        }
        if(!StringUtils.hasLength(supplierDto.getPhone())){
            errors.add("Please enter phone number");
        }
        return errors;
    }
}
