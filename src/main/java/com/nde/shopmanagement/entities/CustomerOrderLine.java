package com.nde.shopmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "customerorderline")
public class CustomerOrderLine extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "iditem")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "idcustomerorder")
    private CustomerOrder customerOrder;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;
}
