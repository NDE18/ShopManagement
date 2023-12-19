package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDto userDto){
        List<String> errors = new ArrayList<>();

        if(userDto == null){
            errors.add("Please enter lastname");
            errors.add("Please enter firstname");
            errors.add("Please enter password");
            errors.add("Please enter address");
            errors.add("Please enter email");
            return errors;
        }

        if(!StringUtils.hasLength(userDto.getLastName())){
            errors.add("Please enter lastname");
        }
        if(!StringUtils.hasLength(userDto.getFirstName())){
            errors.add("Please enter firstname");
        }
        if(!StringUtils.hasLength(userDto.getEmail())){
            errors.add("Please enter email");
        }
        if(!StringUtils.hasLength(userDto.getPwd())){
            errors.add("Please enter password");
        }
        if(userDto.getBirth() == null){
            errors.add("Please enter birthdate");
        }
        if(userDto.getAddress() == null){
            errors.add("Please enter address");
        }
        else {
            if(!StringUtils.hasLength(userDto.getAddress().getAddress1())){
                errors.add("Please enter address 1");
            }
            if(!StringUtils.hasLength(userDto.getAddress().getCity())){
                errors.add("Please enter city");
            }
            if(!StringUtils.hasLength(userDto.getAddress().getPBox())){
                errors.add("Please enter PBox");
            }
            if(!StringUtils.hasLength(userDto.getAddress().getCountry())){
                errors.add("Please enter country");
            }
        }
        return errors;
    }
}
