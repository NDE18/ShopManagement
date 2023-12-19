package com.nde.shopmanagement.validators;

import com.nde.shopmanagement.dto.ItemDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ItemValidator {

    public static List<String> validate(ItemDto itemDto){
        List<String> errors = new ArrayList<>();

        if(itemDto == null){
            errors.add("Please enter item code");
            errors.add("Please enter item designation");
            errors.add("Please enter unit price HT");
            errors.add("Please enter VAT rate");
            errors.add("Please enter unit price TTC");
            errors.add("Please enter category");
            return errors;
        }

        if(!StringUtils.hasLength(itemDto.getCodeItem())){
            errors.add("Please enter code");
        }
        if(!StringUtils.hasLength(itemDto.getDesignation())){
            errors.add("Please enter designation");
        }
        if(itemDto.getUnitPriceHt() == null){
            errors.add("Please enter unit price HT");
        }
        if(itemDto.getVatRate() == null){
            errors.add("Please enter VAT rate");
        }
        if(itemDto.getUnitPriceTtc() == null){
            errors.add("Please enter unit price TTC");
        }
        if(itemDto.getCategory() == null){
            errors.add("Please select category");
        }
        return errors;
    }
}
