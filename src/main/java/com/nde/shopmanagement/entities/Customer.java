package com.nde.shopmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
public class Customer extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "customerCode")
    private String code;

    @Embedded
    private Address address;

    @Column(name = "image")
    private String image;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "idbusiness")
    private Integer idBusiness;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders;
}
