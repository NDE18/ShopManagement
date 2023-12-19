package com.nde.shopmanagement.dto;


import com.nde.shopmanagement.entities.Sale;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SaleDto {

    private Integer id;

    private String code;

    private Instant saleDate;

    private String comment;

    private List<LineSaleDto> lineSale;

    public static SaleDto fromEntity(Sale sale){
        if (sale == null){
            return null;
        }
        return SaleDto.builder()
                .id(sale.getId())
                .code(sale.getCode())
                .saleDate(sale.getSaleDate())
                .comment(sale.getComment())
                .build();
    }

    public static Sale toEntity(SaleDto sale){
        if (sale == null){
            return null;
        }
        return Sale.builder()
                .id(sale.getId())
                .code(sale.getCode())
                .saleDate(sale.getSaleDate())
                .comment(sale.getComment())
                .build();
    }
}
