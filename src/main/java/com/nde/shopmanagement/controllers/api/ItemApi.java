package com.nde.shopmanagement.controllers.api;

import com.nde.shopmanagement.dto.ItemDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;


public interface ItemApi {

    @PostMapping(value = APP_ROOT + "/items/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Saved new item in database",
            description = "This method permit to save ou update item"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet item save / update"),
            @ApiResponse(responseCode = "400", description = "Item not valid")
    })
    ItemDto save(@RequestBody ItemDto itemDto);

    @GetMapping(value = APP_ROOT + "/items/{idItem}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search item by ID",
            description = "This method find item by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object item found"),
            @ApiResponse(responseCode = "400", description = "Object item not found")
    })
    ItemDto findById(@PathVariable("idItem") Integer id);

    @GetMapping(value = APP_ROOT + "/items/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search item by CODE",
            description = "This method find item by CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object item found"),
            @ApiResponse(responseCode = "400", description = "Object item not found")
    })
    ItemDto findItemCode(@PathVariable("itemCode") String itemCode);

    @GetMapping(value = APP_ROOT + "/items/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search all items",
            description = "This method find all items"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of items"),
            @ApiResponse(responseCode = "400", description = "Empty list")
    })
    List<ItemDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/items/delete/{idItem}")
    @Operation(
            summary = "Delete item by ID",
            description = "This method delete item by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object item deleted"),
            @ApiResponse(responseCode = "400", description = "Object item not found")
    })
    void delete(@PathVariable("idItem") Integer id);
}
