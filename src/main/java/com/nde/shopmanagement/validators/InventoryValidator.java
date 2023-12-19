package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.InventoryDto;

import java.util.ArrayList;
import java.util.List;

public class InventoryValidator {

    public static List<String> validate(InventoryDto inventoryDto){
        List<String> errors = new ArrayList<>();

        if(inventoryDto == null){
            errors.add("Please select inventory date");
            errors.add("Please select items");
            errors.add("Please enter quantity");
            errors.add("Please inventory type");
            return errors;
        }
        if(inventoryDto.getDateInventory() == null){
            errors.add("Please select inventory date");
        }
        if(inventoryDto.getQuantity() == null){
            errors.add("Please enter quantity");
        }
        if(inventoryDto.getItem() == null){
            errors.add("Please select item");
        }
        if(inventoryDto.getInventoryType() == null){
            errors.add("Please select inventory type");
        }
        return errors;
    }
}
