package com.nde.shopmanagement.controllers.api;

import com.nde.shopmanagement.dto.SupplierDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

public interface SupplierApi {

    @PostMapping(value = APP_ROOT + "/suppliers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Saved new supplier in database",
            description = "This method permit to save ou update supplier"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet supplier save / update"),
            @ApiResponse(responseCode = "400", description = "supplier not valid")
    })
    SupplierDto save(@RequestBody SupplierDto supplierDto);

    @GetMapping(value = APP_ROOT + "/suppliers/{idSupplier}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search item by ID",
            description = "This method find item by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object supplier found"),
            @ApiResponse(responseCode = "400", description = "Object supplier not found")
    })
    SupplierDto findById(@PathVariable("idSupplier") Integer id);

    @GetMapping(value = APP_ROOT + "/suppliers/{supplierCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search supplier by CODE",
            description = "This method find supplier by CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object supplier found"),
            @ApiResponse(responseCode = "400", description = "Object supplier not found")
    })
    SupplierDto findSupplierCode(@PathVariable("supplierCode") String supplierCode);

    @GetMapping(value = APP_ROOT + "/suppliers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search all suppliers",
            description = "This method find all suppliers"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of suppliers"),
            @ApiResponse(responseCode = "400", description = "Empty list")
    })
    List<SupplierDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/suppliers/delete/{idSupplier}")
    @Operation(
            summary = "Delete supplier by ID",
            description = "This method delete supplier by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object supplier deleted"),
            @ApiResponse(responseCode = "400", description = "Object supplier not found")
    })
    void delete(@PathVariable("idSupplier") Integer id);
}
