package com.nde.shopmanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private String address1;

    private String address2;

    private String city;

    private String pBox;

    private String country;
}
