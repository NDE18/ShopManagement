package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.CustomerOrderDto;
import com.nde.shopmanagement.dto.SupplierDto;
import com.nde.shopmanagement.dto.SupplierOrderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderValidator {

    public static List<String> validate(SupplierOrderDto supplierOrderDto){
        List<String> errors = new ArrayList<>();
        if(supplierOrderDto == null){
            errors.add("Please enter code");
            errors.add("Please select order date");
            errors.add("Please select custumer");
            errors.add("Please select order lines");
            return errors;
        }
        if(!StringUtils.hasLength(supplierOrderDto.getCode())){
            errors.add("Please enter code");
        }
        if(supplierOrderDto.getOrderDate() == null){
            errors.add("Please select order date");
        }
        if(supplierOrderDto.getSupplier() == null){
            errors.add("Please select customer");
        }
        if(supplierOrderDto.getSupplierOrderLines() == null){
            errors.add("Please select order lines");
        }
        return errors;
    }
}
