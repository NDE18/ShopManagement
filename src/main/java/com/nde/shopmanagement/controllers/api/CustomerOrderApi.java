package com.nde.shopmanagement.controllers.api;

import com.nde.shopmanagement.dto.CustomerOrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

public interface CustomerOrderApi {

    @PostMapping(value = APP_ROOT + "/customerorders/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Saved new customer order in database",
            description = "This method permit to save ou update customer order"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet customer order save / update"),
            @ApiResponse(responseCode = "400", description = "customer order not valid")
    })
    ResponseEntity<CustomerOrderDto> save(@RequestBody CustomerOrderDto customerOrderDto);

    @GetMapping(value = APP_ROOT + "/customerorders/{idCustomerOrder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search customer order by ID",
            description = "This method find customer order by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object customer order found"),
            @ApiResponse(responseCode = "400", description = "Object customer order not found")
    })
    ResponseEntity<CustomerOrderDto> findById(@PathVariable("idCustomerOrder") Integer id);

    @GetMapping(value = APP_ROOT + "/customerorders/{customerOrderCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search customer order by CODE",
            description = "This method find customer order by CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object customer order found"),
            @ApiResponse(responseCode = "400", description = "Object customer order not found")
    })
    ResponseEntity<CustomerOrderDto> findCustomerOrderCode(@PathVariable("customerOrderCode") String customerorderCode);

    @GetMapping(value = APP_ROOT + "/customerorders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search all customer orders",
            description = "This method find all customer orders"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of customer orders"),
            @ApiResponse(responseCode = "400", description = "Empty list")
    })
    ResponseEntity<List<CustomerOrderDto>> findAll();

    @DeleteMapping(value = APP_ROOT + "/customerorders/delete/{idCustomerOrder}")
    @Operation(
            summary = "Delete customer order by ID",
            description = "This method delete customer order by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object customer order deleted"),
            @ApiResponse(responseCode = "400", description = "Object customer order not found")
    })
    ResponseEntity delete(@PathVariable("idCustomerOrder") Integer id);

}
