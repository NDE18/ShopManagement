package com.nde.shopmanagement.controllers.api;

import com.nde.shopmanagement.dto.SupplierOrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

public interface SupplierOrderApi {
    @PostMapping(value = APP_ROOT + "/supplierorders/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Saved new supplier order in database",
            description = "This method permit to save ou update supplier order"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet supplier order save / update"),
            @ApiResponse(responseCode = "400", description = "supplier order not valid")
    })
    ResponseEntity<SupplierOrderDto> save(@RequestBody SupplierOrderDto supplierOrderDto);

    @GetMapping(value = APP_ROOT + "/supplierorders/{idsupplierOrder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search supplier order by ID",
            description = "This method find supplier order by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object supplier order found"),
            @ApiResponse(responseCode = "400", description = "Object supplier order not found")
    })
    ResponseEntity<SupplierOrderDto> findById(@PathVariable("idsupplierOrder") Integer id);

    @GetMapping(value = APP_ROOT + "/supplierorders/{supplierOrderCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search supplier order by CODE",
            description = "This method find supplier order by CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object supplier order found"),
            @ApiResponse(responseCode = "400", description = "Object supplier order not found")
    })
    ResponseEntity<SupplierOrderDto> findSupplierOrderCode(@PathVariable("supplierOrderCode") String supplierOrderCode);

    @GetMapping(value = APP_ROOT + "/supplierorders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search all supplier orders",
            description = "This method find all supplier orders"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of supplier orders"),
            @ApiResponse(responseCode = "400", description = "Empty list")
    })
    ResponseEntity<List<SupplierOrderDto>> findAll();

    @DeleteMapping(value = APP_ROOT + "/supplierorders/delete/{idSupplierOrder}")
    @Operation(
            summary = "Delete supplier order by ID",
            description = "This method delete supplier order by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object supplier order deleted"),
            @ApiResponse(responseCode = "400", description = "Object supplier order not found")
    })
    ResponseEntity delete(@PathVariable("idSupplierOrder") Integer id);
}
