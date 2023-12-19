package com.nde.shopmanagement.controllers.api;

import com.nde.shopmanagement.dto.SaleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

public interface SaleApi {

    @PostMapping(value = APP_ROOT + "/sales/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Saved new Sale in database",
            description = "This method permit to save ou update Sale"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet Sale save / update"),
            @ApiResponse(responseCode = "400", description = "Sale not valid")
    })
    ResponseEntity<SaleDto> save(@RequestBody SaleDto saleDto);

    @GetMapping(value = APP_ROOT + "/sales/{idSale}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search Sale by ID",
            description = "This method find Sale by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object Sale found"),
            @ApiResponse(responseCode = "400", description = "Object Sale not found")
    })
    ResponseEntity<SaleDto> findById(@PathVariable("idSale") Integer id);

    @GetMapping(value = APP_ROOT + "/sales/{saleCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search Sale by CODE",
            description = "This method find Sale by CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object Sale found"),
            @ApiResponse(responseCode = "400", description = "Object Sale not found")
    })
    ResponseEntity<SaleDto> findSaleCode(@PathVariable("saleCode") String SaleCode);

    @GetMapping(value = APP_ROOT + "/sales/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search all sales",
            description = "This method find all sales"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of sales"),
            @ApiResponse(responseCode = "400", description = "Empty list")
    })
    ResponseEntity<List<SaleDto>> findAll();

    @DeleteMapping(value = APP_ROOT + "/sales/delete/{idSale}")
    @Operation(
            summary = "Delete Sale by ID",
            description = "This method delete Sale by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object Sale deleted"),
            @ApiResponse(responseCode = "400", description = "Object Sale not found")
    })
    ResponseEntity delete(@PathVariable("idSale") Integer id);
}
