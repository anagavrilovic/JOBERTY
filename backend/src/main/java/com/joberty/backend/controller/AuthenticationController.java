package com.joberty.backend.controller;

import com.joberty.backend.dto.JwtAuthenticationRequestDto;
import com.joberty.backend.dto.RegisteredUserDto;
import com.joberty.backend.dto.UserTokenState;
import com.joberty.backend.exception.UsernameNotFoundException;
import com.joberty.backend.model.RegisteredUser;
import com.joberty.backend.service.interfaces.RegisteredUserService;
import com.joberty.backend.util.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AuthenticationController {

    private final TokenUtils tokenUtils;
    private final AuthenticationManager authenticationManager;
    private final RegisteredUserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequestDto authenticationRequest)  {

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        }
        catch (Exception ex){
            throw new UsernameNotFoundException();
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        RegisteredUser user = (RegisteredUser) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername());
        int expiresIn = tokenUtils.getExpiredIn();

        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, user.getRole().getName()));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisteredUserDto> registerUser(@RequestBody RegisteredUserDto userDTO){
        RegisteredUserDto user = userService.registerUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
