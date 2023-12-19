package com.nde.shopmanagement.controllers;


import com.nde.shopmanagement.dto.auth.AuthenticationRequest;
import com.nde.shopmanagement.dto.auth.AuthenticationResponse;
import com.nde.shopmanagement.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nde.shopmanagement.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
public class AuthenticationController {

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken("dummy_acces_token").build());
    }
}
