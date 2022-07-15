package com.joberty.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Registration request not found!")
public class RegistrationRequestNotFoundException extends RuntimeException{
}
