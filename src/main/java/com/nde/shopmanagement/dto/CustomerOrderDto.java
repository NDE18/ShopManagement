package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.CustomerOrder;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CustomerOrderDto {

    private Integer id;

    private String code;

    private Instant orderDate;

    private CustomerDto customer;

    private List<CustomerOrderLineDto> customerOrderLines;

    public  static CustomerOrderDto fromEntity(CustomerOrder customerOrder){
        if (customerOrder == null){
            return null;
        }
        return CustomerOrderDto.builder()
                .id(customerOrder.getId())
                .code(customerOrder.getCode())
                .orderDate(customerOrder.getOrderDate())
                .customer(CustomerDto.fromEntity(customerOrder.getCustomer()))
                .build();
    }

    public static CustomerOrder toEntity(CustomerOrderDto customerOrder){
        if (customerOrder == null){
            return null;
        }
        return CustomerOrder.builder()
                .id(customerOrder.getId())
                .code(customerOrder.getCode())
                .orderDate(customerOrder.getOrderDate())
                .customer(CustomerDto.toEntity(customerOrder.getCustomer()))
                .build();
    }
}
