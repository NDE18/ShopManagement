package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.Address;
import com.nde.shopmanagement.entities.Business;
import com.nde.shopmanagement.entities.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BusinessDto {

    private Integer id;

    private String name;

    private String description;

    private Address address;

    private String taxCode;

    private String photo;

    private String email;

    private String phone;

    private String siteWeb;

    private List<UserDto> user;

    public static BusinessDto fromEntity(Business business){
        if (business == null){
            return null;
        }
        return BusinessDto.builder()
                .id(business.getId())
                .description(business.getDescription())
                .name(business.getName())
                .phone(business.getPhone())
                .photo(business.getPhoto())
                .taxCode(business.getTaxCode())
                .siteWeb(business.getSiteWeb())
                .address(business.getAddress())
                .build();
    }

    public static Business toEntity(BusinessDto businessDto){
        if (businessDto == null){
            return null;
        }
        return Business.builder()
                .id(businessDto.getId())
                .description(businessDto.getDescription())
                .name(businessDto.getName())
                .phone(businessDto.getPhone())
                .photo(businessDto.getPhoto())
                .taxCode(businessDto.getTaxCode())
                .siteWeb(businessDto.getSiteWeb())
                .address(businessDto.getAddress())
                .build();
    }
}
