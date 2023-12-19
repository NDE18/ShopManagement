package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.Category;
import com.nde.shopmanagement.entities.Item;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemDto {

    private Integer id;

    private String codeItem;

    private String designation;

    private BigDecimal unitPriceHt;

    private BigDecimal vatRate;

    private BigDecimal unitPriceTtc;

    private String image;

    private CategoryDto category;

    public static ItemDto fromEntity(Item item){
        if (item == null){
            return null;
        }
        return ItemDto.builder()
                .codeItem(item.getCodeItem())
                .designation(item.getDesignation())
                .unitPriceHt(item.getUnitPriceHt())
                .unitPriceTtc(item.getUnitPriceTtc())
                .vatRate(item.getVatRate())
                .build();
    }
    public static Item toEntity(ItemDto item){
        if (item == null){
            return null;
        }
        return Item.builder()
                .codeItem(item.getCodeItem())
                .designation(item.getDesignation())
                .unitPriceHt(item.getUnitPriceHt())
                .unitPriceTtc(item.getUnitPriceTtc())
                .vatRate(item.getVatRate())
                .build();
    }
}
