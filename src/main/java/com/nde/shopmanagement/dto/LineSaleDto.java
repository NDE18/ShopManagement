package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.LineSale;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LineSaleDto {

    private Integer id;

    private SaleDto sale;

    private ItemDto item;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    public static LineSaleDto fromEntity(LineSale lineSale){
        if (lineSale == null){
            return  null;
        }
        return LineSaleDto.builder()
                .id(lineSale.getId())
                .item(ItemDto.fromEntity(lineSale.getItem()))
                .quantity(lineSale.getQuantity())
                .unitPrice(lineSale.getUnitPrice())
                .sale(SaleDto.fromEntity(lineSale.getSale()))
                .build();
    }

    public static LineSale toEntity(LineSaleDto lineSale){
        if (lineSale == null){
            return  null;
        }
        return LineSale.builder()
                .id(lineSale.getId())
                .item(ItemDto.toEntity(lineSale.getItem()))
                .quantity(lineSale.getQuantity())
                .unitPrice(lineSale.getUnitPrice())
                .sale(SaleDto.toEntity(lineSale.getSale()))
                .build();
    }
}
