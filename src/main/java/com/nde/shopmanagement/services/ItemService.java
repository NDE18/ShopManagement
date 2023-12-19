package com.nde.shopmanagement.services;

import com.nde.shopmanagement.dto.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto save(ItemDto itemDto);

    ItemDto findById(Integer id);

    ItemDto findItemCode(String itemCode);

    List<ItemDto> findAll();

    void delete(Integer id);
}
