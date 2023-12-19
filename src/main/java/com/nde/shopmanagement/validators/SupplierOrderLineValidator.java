package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.SupplierOrderLineDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderLineValidator {

    public static List<String> validate(SupplierOrderLineDto supplierOrderLineDto){
        List<String> errors = new ArrayList<>();
        if(supplierOrderLineDto == null){
            errors.add("Please select supplier order");
            errors.add("Please select items");
            errors.add("Please enter quantity");
            errors.add("Please enter unit price");
        }
        if(supplierOrderLineDto.getSupplierOrders() == null){
            errors.add("Please select customer order");
        }
        if(supplierOrderLineDto.getItem() == null){
            errors.add("Please select item");
        }
        if(supplierOrderLineDto.getUnitPrice() == null){
            errors.add("Please enter unit price");
        }
        if(supplierOrderLineDto.getQuantity() == null){
            errors.add("Please enter quantity");
        }
        return errors;
    }
}
