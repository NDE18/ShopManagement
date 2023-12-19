package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.CustomerOrderLineDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderLineValidator {

    public static List<String> validate(CustomerOrderLineDto customerOrderLineDto){
        List<String> errors = new ArrayList<>();
        if(customerOrderLineDto == null){
            errors.add("Please select customer order");
            errors.add("Please select items");
            errors.add("Please enter quantity");
            errors.add("Please enter unit price");
        }
        if(customerOrderLineDto.getCustomerOrder() == null){
            errors.add("Please select customer order");
        }
        if(customerOrderLineDto.getItem() == null){
            errors.add("Please select item");
        }
        if(customerOrderLineDto.getUnitPrice() == null){
            errors.add("Please enter unit price");
        }
        if(customerOrderLineDto.getQuantity() == null){
            errors.add("Please enter quantity");
        }
        return errors;
    }
}
