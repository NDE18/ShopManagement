package com.nde.shopmanagement.services;

import com.nde.shopmanagement.dto.InventoryDto;
import com.nde.shopmanagement.dto.ItemDto;

import java.util.List;

public interface InventoryService {

    InventoryDto save(InventoryDto inventoryDto);

    InventoryDto findById(Integer id);


    List<InventoryDto> findAll();

    void delete(Integer id);
}
