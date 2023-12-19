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
@Table(name = "supplier")
public class Supplier extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

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

    @OneToMany(mappedBy = "supplier")
    private List<SupplierOrder> supplierOrders;
}
