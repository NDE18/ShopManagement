package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.BusinessDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class BusinessValidator {

    public static List<String> validate(BusinessDto businessDto){
        List<String> errors = new ArrayList<>();

        if(businessDto == null){
            errors.add("Please enter name");
            errors.add("Please enter tax code");
            errors.add("Please enter description");
            errors.add("Please enter phone");
            errors.add("Please enter email");
            return errors;
        }
        if(!StringUtils.hasLength(businessDto.getName())){
            errors.add("Please enter name");
        }
        if(!StringUtils.hasLength(businessDto.getTaxCode())){
            errors.add("Please enter tax code");
        }
        if(!StringUtils.hasLength(businessDto.getDescription())){
            errors.add("Please enter description");
        }
        if(!StringUtils.hasLength(businessDto.getEmail())){
            errors.add("Please enter email");
        }
        if(!StringUtils.hasLength(businessDto.getPhone())){
            errors.add("Please enter phone number");
        }
        if(businessDto.getAddress() == null){
            errors.add("Please enter address");
        }
        else {
            if(!StringUtils.hasLength(businessDto.getAddress().getAddress1())){
                errors.add("Please enter address 1");
            }
            if(!StringUtils.hasLength(businessDto.getAddress().getCity())){
                errors.add("Please enter city");
            }
            if(!StringUtils.hasLength(businessDto.getAddress().getPBox())){
                errors.add("Please enter PBox");
            }
            if(!StringUtils.hasLength(businessDto.getAddress().getCountry())){
                errors.add("Please enter country");
            }
        }
        return errors;
    }
}
