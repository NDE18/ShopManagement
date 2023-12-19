package com.nde.shopmanagement.dto;

import com.nde.shopmanagement.entities.Inventory;
import com.nde.shopmanagement.entities.InventoryType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class InventoryDto {

    private Integer id;

    private Instant dateInventory;

    private BigDecimal quantity;

    private ItemDto item;

    private InventoryType inventoryType;

    public static InventoryDto fromEntity(Inventory inventory){
        if (inventory == null){
            return null;
        }
        return InventoryDto.builder()
                .id(inventory.getId())
                .dateInventory(inventory.getDateInventory())
                .quantity(inventory.getQuantity())
                .item(ItemDto.fromEntity(inventory.getItem()))
                .inventoryType(inventory.getInventoryType())
                .build();
    }

    public static Inventory toEntity(InventoryDto inventory){
        if (inventory == null){
            return null;
        }
        return Inventory.builder()
                .id(inventory.getId())
                .dateInventory(inventory.getDateInventory())
                .quantity(inventory.getQuantity())
                .item(ItemDto.toEntity(inventory.getItem()))
                .inventoryType(inventory.getInventoryType())
                .build();
    }
}
