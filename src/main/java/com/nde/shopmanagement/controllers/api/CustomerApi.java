package com.nde.shopmanagement.controllers.api;

import com.nde.shopmanagement.dto.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

public interface CustomerApi {

    @PostMapping(value = APP_ROOT + "/customers/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Saved new customer in database",
            description = "This method permit to save ou update customer"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet customer save / update"),
            @ApiResponse(responseCode = "400", description = "customer not valid")
    })
    CustomerDto save(@RequestBody CustomerDto CustomerDto);

    @GetMapping(value = APP_ROOT + "/customers/{idcustomer}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search item by ID",
            description = "This method find item by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object customer found"),
            @ApiResponse(responseCode = "400", description = "Object customer not found")
    })
    CustomerDto findById(@PathVariable("idcustomer") Integer id);

    @GetMapping(value = APP_ROOT + "/customers/{customerCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search customer by CODE",
            description = "This method find customer by CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object customer found"),
            @ApiResponse(responseCode = "400", description = "Object customer not found")
    })
    CustomerDto findCustomerCode(@PathVariable("customerCode") String customerCode);

    @GetMapping(value = APP_ROOT + "/customers/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search all customers",
            description = "This method find all customers"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of customers"),
            @ApiResponse(responseCode = "400", description = "Empty list")
    })
    List<CustomerDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/customers/delete/{idCustomer}")
    @Operation(
            summary = "Delete customer by ID",
            description = "This method delete customer by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object customer deleted"),
            @ApiResponse(responseCode = "400", description = "Object customer not found")
    })
    void delete(@PathVariable("idCustomer") Integer id);
}
