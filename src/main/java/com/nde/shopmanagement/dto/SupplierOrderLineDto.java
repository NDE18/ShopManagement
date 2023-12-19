package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.CustomerOrderLine;
import com.nde.shopmanagement.entities.SupplierOrderLine;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class SupplierOrderLineDto {

    private Integer id;

    private ItemDto item;

    private SupplierOrderDto supplierOrders;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    public static SupplierOrderLineDto fromEntity(SupplierOrderLine supplierOrderLine){
        if (supplierOrderLine == null){
            return null;
        }
        return SupplierOrderLineDto.builder()
                .id(supplierOrderLine.getId())
                .item(ItemDto.fromEntity(supplierOrderLine.getItem()))
                .quantity(supplierOrderLine.getQuantity())
                .unitPrice(supplierOrderLine.getUnitPrice())
                .build();
    }

    public static SupplierOrderLine toEntity(SupplierOrderLineDto supplierOrderLine){
        if(supplierOrderLine == null){
            return null;
        }
        return SupplierOrderLine.builder()
                .id(supplierOrderLine.getId())
                .item(ItemDto.toEntity(supplierOrderLine.getItem()))
                .quantity(supplierOrderLine.getQuantity())
                .unitPrice(supplierOrderLine.getUnitPrice())
                .build();
    }
}
