package com.nde.shopmanagement.services;

import com.nde.shopmanagement.dto.ItemDto;
import com.nde.shopmanagement.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto findById(Integer id);

    UserDto findItemCode(String itemCode);

    List<UserDto> findAll();

    void delete(Integer id);
}
