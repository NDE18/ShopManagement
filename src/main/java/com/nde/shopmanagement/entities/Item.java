package com.nde.shopmanagement.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "item")
@Schema(
        description = "This is the item entity"
)
public class Item extends AbstractEntity{

    @Column(name = "iditem")
    private Integer id;

    @Column(name = "codeitem")
    private String codeItem;

    @Column(name = "designation")
    private String designation;

    @Column(name = "unitpriceht")
    private BigDecimal unitPriceHt;

    @Column(name = "vatrate")
    private BigDecimal vatRate;

    @Column(name = "unitpricettc")
    private BigDecimal unitPriceTtc;

    @Column(name = "image")
    private String image;

    @Column(name = "idbusiness")
    private Integer idBusiness;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;
}
