package com.nde.shopmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customerorder")
public class CustomerOrder extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "orderdate")
    private Instant orderDate;

    @ManyToOne
    @JoinColumn(name = "idcustomer")
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder")
    private List<CustomerOrderLine> customerOrderLines;
}
