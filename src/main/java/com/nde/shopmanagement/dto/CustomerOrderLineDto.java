package com.nde.shopmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nde.shopmanagement.entities.CustomerOrderLine;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CustomerOrderLineDto {

    private Integer id;

    private ItemDto item;

    @JsonIgnore
    private CustomerOrderDto customerOrder;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    public static CustomerOrderLineDto fromEntity(CustomerOrderLine customerOrderLine){
        if (customerOrderLine == null){
            return null;
        }
        return CustomerOrderLineDto.builder()
                .id(customerOrderLine.getId())
                .item(ItemDto.fromEntity(customerOrderLine.getItem()))
                .quantity(customerOrderLine.getQuantity())
                .unitPrice(customerOrderLine.getUnitPrice())
                .build();
    }

    public static CustomerOrderLine toEntity(CustomerOrderLineDto customerOrderLine){
        if(customerOrderLine == null){
            return null;
        }
        return CustomerOrderLine.builder()
                .id(customerOrderLine.getId())
                .item(ItemDto.toEntity(customerOrderLine.getItem()))
                .quantity(customerOrderLine.getQuantity())
                .unitPrice(customerOrderLine.getUnitPrice())
                .build();
    }
}
