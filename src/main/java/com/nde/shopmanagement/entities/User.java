package com.nde.shopmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "birth")
    private String birth;

    @Embedded
    private Address address;

    @Column(name = "image")
    private String image;

    @Column(name = "email")
    private String email;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "idbusiness")
    private Business business;
}
