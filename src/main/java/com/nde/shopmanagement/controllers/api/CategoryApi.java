package com.nde.shopmanagement.controllers.api;

import com.nde.shopmanagement.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

public interface CategoryApi {
    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Saved new category in database",
            description = "This method permit to save ou update category"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet category save / update"),
            @ApiResponse(responseCode = "400", description = "Category not valid")
    })
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value = APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search item by ID",
            description = "This method find item by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object category found"),
            @ApiResponse(responseCode = "400", description = "Object category not found")
    })
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping(value = APP_ROOT + "/categories/{categoryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search category by CODE",
            description = "This method find category by CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object category found"),
            @ApiResponse(responseCode = "400", description = "Object category not found")
    })
    CategoryDto findCategoryCode(@PathVariable("categoryCode") String categoryCode);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search all categories",
            description = "This method find all categories"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of categories"),
            @ApiResponse(responseCode = "400", description = "Empty list")
    })
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")
    @Operation(
            summary = "Delete category by ID",
            description = "This method delete category by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object category deleted"),
            @ApiResponse(responseCode = "400", description = "Object category not found")
    })
    void delete(@PathVariable("idCategory") Integer id);
}
