package com.nde.shopmanagement.services.impl;

import com.nde.shopmanagement.dto.UserDto;
import com.nde.shopmanagement.entities.User;
import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.exceptions.InvalidEntityException;
import com.nde.shopmanagement.repositories.UserRepository;
import com.nde.shopmanagement.services.UserService;
import com.nde.shopmanagement.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto userDto) {
        List<String> errors = UserValidator.validate(userDto);
        if(!errors.isEmpty()){
            log.error("User is not valid {}", userDto);
            throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_FOUND, errors);
        }
        return UserDto.fromEntity(userRepository.save(UserDto.toEntity(userDto)));
    }

    @Override
    public UserDto findById(Integer id) {
        if(id == null){
            log.error("ID user is null {}", id);
            return null;
        }
        Optional<User> user = userRepository.findById(id);

        UserDto userDto = UserDto.fromEntity(user.get());
        return Optional.of(userDto).orElseThrow(() -> new EntityNotFoundException(
                "No user with ID = "+id+" found.",
                ErrorCodes.USER_NOT_FOUND
        ));
    }

    @Override
    public UserDto findItemCode(String itemCode) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream().map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            return;
        }
        userRepository.deleteById(id);
    }
}
