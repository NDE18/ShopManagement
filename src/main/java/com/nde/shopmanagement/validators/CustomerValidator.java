package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.CustomerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {

    public static List<String> validate(CustomerDto customerDto){
        List<String> errors = new ArrayList<>();

        if(customerDto == null){
            errors.add("Please enter lastname");
            errors.add("Please enter firstname");
            errors.add("Please enter password");
            errors.add("Please enter email");
            return errors;
        }
        if(!StringUtils.hasLength(customerDto.getLastName())){
            errors.add("Please enter lastname");
        }
        if(!StringUtils.hasLength(customerDto.getFirstName())){
            errors.add("Please enter firstname");
        }
        if(!StringUtils.hasLength(customerDto.getEmail())){
            errors.add("Please enter email");
        }
        if(!StringUtils.hasLength(customerDto.getPhone())){
            errors.add("Please enter phone number");
        }
        return errors;
    }
}
