package com.nde.shopmanagement.controllers;

import com.nde.shopmanagement.controllers.api.ItemApi;
import com.nde.shopmanagement.dto.ItemDto;
import com.nde.shopmanagement.services.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(
        name = "Item Controller All CRUD API",
        description = "This class implements all the CRUD api related for item management"
)
public class ItemController implements ItemApi {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @Override
    public ItemDto save(ItemDto itemDto) {
        return itemService.save(itemDto);
    }

    @Override
    public ItemDto findById(Integer id) {
        return itemService.findById(id);
    }

    @Override
    public ItemDto findItemCode(String itemCode) {
        return itemService.findItemCode(itemCode);
    }

    @Override
    public List<ItemDto> findAll() {
        return itemService.findAll();
    }

    @Override
    public void delete(Integer id) {
        itemService.delete(id);
    }
}
