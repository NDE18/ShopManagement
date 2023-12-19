package com.nde.shopmanagement.controllers.api;

/*import com.nde.shopmanagement.dto.ItemDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/items")
public interface ItemApi {

    @PostMapping(value = APP_ROOT + "/items/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save an item", notes = "This method permit to save ou update item", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Objet item save / update"),
            @ApiResponse(code = 400, message = "Item not valid")
    })
    ItemDto save(@RequestBody ItemDto itemDto);

    @GetMapping(value = APP_ROOT + "/items/{idItem}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search an item by id", notes = "This method permit to search an item by id", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item has been found"),
            @ApiResponse(code = 404, message = "No item found with id provide")
    })
    ItemDto findById(@PathVariable("idItem") Integer id);

    @GetMapping(value = APP_ROOT + "/item/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search an item by code", notes = "This method permit to search an item by code", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item has been found"),
            @ApiResponse(code = 404, message = "No item found with code provide")
    })
    ItemDto findItemCode(@PathVariable("itemCode") String itemCode);

    @GetMapping(value = APP_ROOT + "/items/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Return item lists", notes = "This method permit to search and return item lists", response = ItemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item lists / empty list"),
    })
    List<ItemDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/items/delete/{idItem}")
    @ApiOperation(value = "Delete an item", notes = "This method permit to delete an item by id", responseContainer = "List<ItemDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Item has been deleted")
    })
    void delete(@PathVariable("idItem") Integer id);
}*/
