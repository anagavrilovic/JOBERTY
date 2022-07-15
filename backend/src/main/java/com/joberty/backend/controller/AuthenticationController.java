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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static com.joberty.backend.JobertyApplication.LOGGER_INFO;
import static com.joberty.backend.JobertyApplication.LOGGER_WARNING;

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
            LOGGER_WARNING.warn("User: " + authenticationRequest.getEmail() + " | Action: L");
            throw new UsernameNotFoundException();
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        RegisteredUser user = (RegisteredUser) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername());
        int expiresIn = tokenUtils.getExpiredIn();

        LOGGER_INFO.info("User: " + authenticationRequest.getEmail() + " | Action: L");
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, user.getRole().getName()));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisteredUserDto> registerUser(@RequestBody RegisteredUserDto userDTO){
        RegisteredUserDto user = userService.registerUser(userDTO);
        LOGGER_INFO.info("User: " + userDTO.getEmail() + " | Action: R");
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/whoami")
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<RegisteredUserDto> getLoggedInUser(Principal principal) {
        RegisteredUserDto user = userService.getUserByUsername(principal.getName());
        LOGGER_INFO.info("User: " + principal.getName() + " | Action: W");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
