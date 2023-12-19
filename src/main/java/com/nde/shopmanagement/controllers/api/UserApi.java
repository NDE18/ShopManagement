package com.nde.shopmanagement.controllers.api;

import com.nde.shopmanagement.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

public interface UserApi {

    @PostMapping(value = APP_ROOT + "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Saved new user in database",
            description = "This method permit to save ou update user"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objet user save / update"),
            @ApiResponse(responseCode = "400", description = "user not valid")
    })
    ResponseEntity<UserDto> save(@RequestBody UserDto userDto);

    @GetMapping(value = APP_ROOT + "/users/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search user by ID",
            description = "This method find user by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object user found"),
            @ApiResponse(responseCode = "400", description = "Object user not found")
    })
    ResponseEntity<UserDto> findById(@PathVariable("idUser") Integer id);

    @GetMapping(value = APP_ROOT + "/users/{userCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search user by CODE",
            description = "This method find user by CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object user found"),
            @ApiResponse(responseCode = "400", description = "Object user not found")
    })
    ResponseEntity<UserDto> findUserCode(@PathVariable("userCode") String userCode);

    @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Search all users",
            description = "This method find all users"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of users"),
            @ApiResponse(responseCode = "400", description = "Empty list")
    })
    ResponseEntity<List<UserDto>> findAll();

    @DeleteMapping(value = APP_ROOT + "/users/delete/{idUser}")
    @Operation(
            summary = "Delete user by ID",
            description = "This method delete user by ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object user deleted"),
            @ApiResponse(responseCode = "400", description = "Object user not found")
    })
    ResponseEntity delete(@PathVariable("idUser") Integer id);
}
