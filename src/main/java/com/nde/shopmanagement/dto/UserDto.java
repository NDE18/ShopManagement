package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Integer id;

    private String lastName;

    private String firstName;

    private String birth;

    private AddressDto address;

    private String image;

    private String email;

    private String pwd;

    private String phone;

    private BusinessDto business;

    public static UserDto fromEntity(User user){
        if(user == null){
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .email(user.getEmail())
                .phone(user.getPhone())
                .image(user.getImage())
                .build();
    }

    public static User toEntity(UserDto user){
        if(user == null){
            return null;
        }
        return User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birth(user.getBirth())
                .email(user.getEmail())
                .phone(user.getPhone())
                .image(user.getImage())
                .build();
    }
}
