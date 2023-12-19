package com.nde.shopmanagement.services.auth;

import com.nde.shopmanagement.exceptions.EntityNotFoundException;
import com.nde.shopmanagement.exceptions.ErrorCodes;
import com.nde.shopmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.nde.shopmanagement.entities.User user = userRepository.findByEmail(username).orElseThrow(
                () -> new EntityNotFoundException("No user found with email provided", ErrorCodes.USER_NOT_FOUND)
        );



        return new User(user.getEmail(), user.getPwd(), Collections.emptyList());
    }
}
