package com.nde.shopmanagement.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "supplierorder")
public class SupplierOrder extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "orderdate")
    private Instant orderDate;

    @Column(name = "idbusiness")
    private Integer idBusiness;

    @ManyToOne
    @JoinColumn(name="idsupplier")
    private Supplier supplier;

    @OneToMany(mappedBy = "supplierOrder")
    private List<SupplierOrderLine> supplierOrderLines;
}
