package com.nde.shopmanagement.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "inventory")
public class Inventory extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @Column(name = "dateinventory")
    private Instant dateInventory;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "iditem")
    private Item item;

    @Column(name = "idbusiness")
    private Integer idBusiness;

    @Column(name = "inventorytype")
    private InventoryType inventoryType;
}
