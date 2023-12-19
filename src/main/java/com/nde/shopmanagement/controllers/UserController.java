package com.nde.shopmanagement.controllers;

import com.nde.shopmanagement.controllers.api.UserApi;
import com.nde.shopmanagement.dto.UserDto;
import com.nde.shopmanagement.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(
        name = "User Controller All CRUD API",
        description = "This class implements all the CRUD api related for user management"
)
public class UserController implements UserApi {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDto> save(UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @Override
    public ResponseEntity<UserDto> findById(Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Override
    public ResponseEntity<UserDto> findUserCode(String userCode) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
