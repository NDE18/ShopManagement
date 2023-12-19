package com.nde.shopmanagement.controllers.api;

import com.nde.shopmanagement.dto.BusinessDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

public interface BusinessApi {

    @PostMapping(value = APP_ROOT + "/businesses/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Saved new business in database",
            description = "This method permit to save ou update business"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet business save / update"),
            @ApiResponse(responseCode = "400", description = "business not valid")
    })
    ResponseEntity<BusinessDto> save(@RequestBody BusinessDto businessDto);

    @GetMapping(value = APP_ROOT + "/businesses/{idBusiness}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search business by ID",
            description = "This method find business by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object business found"),
            @ApiResponse(responseCode = "400", description = "Object business not found")
    })
    ResponseEntity<BusinessDto> findById(@PathVariable("idBusiness") Integer id);

    @GetMapping(value = APP_ROOT + "/businesses/{businessCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search business by CODE",
            description = "This method find business by CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object business found"),
            @ApiResponse(responseCode = "400", description = "Object business not found")
    })
    ResponseEntity<BusinessDto> findBusinessCode(@PathVariable("businessCode") String businessCode);

    @GetMapping(value = APP_ROOT + "/businesses/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search all businesss",
            description = "This method find all businesss"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of businesses"),
            @ApiResponse(responseCode = "400", description = "Empty list")
    })
    ResponseEntity<List<BusinessDto>> findAll();

    @DeleteMapping(value = APP_ROOT + "/businesses/delete/{idBusiness}")
    @Operation(
            summary = "Delete business by ID",
            description = "This method delete business by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object business deleted"),
            @ApiResponse(responseCode = "400", description = "Object business not found")
    })
    ResponseEntity delete(@PathVariable("idBusiness") Integer id);
}
