package com.nde.shopmanagement.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "supplierorderline")
public class SupplierOrderLine extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "iditem")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "idsupplierorder")
    private SupplierOrder supplierOrder;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "idbusiness")
    private Integer idBusiness;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;
}
