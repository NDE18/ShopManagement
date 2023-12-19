package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.CustomerOrderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderValidator {
     public static List<String> validate(CustomerOrderDto customerOrderDto){
         List<String> errors = new ArrayList<>();
         if(customerOrderDto == null){
             errors.add("Please enter code");
             errors.add("Please select order date");
             errors.add("Please select custumer");
             errors.add("Please select order lines");
             return errors;
         }
         if(!StringUtils.hasLength(customerOrderDto.getCode())){
             errors.add("Please enter code");
         }
         if(customerOrderDto.getOrderDate() == null){
             errors.add("Please select order date");
         }
         if(customerOrderDto.getCustomer() == null){
             errors.add("Please select customer");
         }
         if(customerOrderDto.getCustomerOrderLines() == null){
             errors.add("Please select order lines");
         }
         return errors;
     }
}
