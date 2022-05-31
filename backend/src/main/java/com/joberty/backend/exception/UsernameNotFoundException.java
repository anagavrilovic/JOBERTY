package com.joberty.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Username not found!")
public class UsernameNotFoundException extends RuntimeException{
}
