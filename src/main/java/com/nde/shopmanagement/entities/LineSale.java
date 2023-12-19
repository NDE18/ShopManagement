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
@Table(name = "linesale")
public class LineSale extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idsale")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "iditem")
    private Item item;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unitprice")
    private BigDecimal unitPrice;

    @Column(name = "idbusiness")
    private Integer idBusiness;
}
