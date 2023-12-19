package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.Supplier;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SupplierDto {

    private Integer id;

    private String lastName;

    private String firstName;

    private AddressDto address;

    private String image;

    private String email;

    private String phone;

    private List<SupplierOrderDto> supplierOrders;

    public static SupplierDto fromEntity(Supplier supplier){
        if(supplier == null){
            return null;
        }
        return SupplierDto.builder()
                .id(supplier.getId())
                .firstName(supplier.getFirstName())
                .lastName(supplier.getLastName())
                .email(supplier.getEmail())
                .image(supplier.getImage())
                .phone(supplier.getPhone())
                .build();
    }

    public static Supplier toEntity(SupplierDto supplier){
        if(supplier == null){
            return null;
        }
        return Supplier.builder()
                .id(supplier.getId())
                .firstName(supplier.getFirstName())
                .lastName(supplier.getLastName())
                .email(supplier.getEmail())
                .image(supplier.getImage())
                .phone(supplier.getPhone())
                .build();
    }
}
