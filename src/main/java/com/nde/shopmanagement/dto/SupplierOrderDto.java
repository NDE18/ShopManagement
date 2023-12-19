package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.Supplier;
import com.nde.shopmanagement.entities.SupplierOrder;
import com.nde.shopmanagement.entities.SupplierOrderLine;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SupplierOrderDto {

    private Integer id;

    private String code;

    private Instant orderDate;

    private SupplierDto supplier;

    private List<SupplierOrderLineDto> supplierOrderLines;

    public static SupplierOrderDto fromEntity(SupplierOrder supplierOrder){
        if (supplierOrder == null){
            return null;
        }
        return SupplierOrderDto.builder()
                .id(supplierOrder.getId())
                .code(supplierOrder.getCode())
                .orderDate(supplierOrder.getOrderDate())
                .supplier(SupplierDto.fromEntity(supplierOrder.getSupplier()))
                .build();
    }

    public static SupplierOrder toEntity(SupplierOrderDto supplierOrder){
        if(supplierOrder == null){
            return null;
        }
        return SupplierOrder.builder()
                .id(supplierOrder.getId())
                .code(supplierOrder.getCode())
                .orderDate(supplierOrder.getOrderDate())
                .supplier(SupplierDto.toEntity(supplierOrder.getSupplier()))
                .build();
    }
}
