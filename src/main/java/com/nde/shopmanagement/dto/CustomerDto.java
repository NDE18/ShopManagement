package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.Address;
import com.nde.shopmanagement.entities.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerDto {

    private Integer id;

    private String lastName;

    private String firstName;

    private Address address;

    private String image;

    private String email;

    private String phone;

    private List<CustomerOrderDto> customerOrders;

    public static CustomerDto fromEntity(Customer customer){
        if(customer == null){
            return null;
        }
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    public static Customer toEntity(CustomerDto customerDto){
        if (customerDto == null){
            return null;
        }
        return Customer.builder()
                .id(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .phone(customerDto.getPhone())
                .build();
    }
}
