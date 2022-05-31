package com.joberty.backend.service.interfaces;

import com.joberty.backend.dto.RegisteredUserDto;

public interface RegisteredUserService {

    RegisteredUserDto registerUser(RegisteredUserDto userDTO);

    RegisteredUserDto saveUser(RegisteredUserDto userDTO);
}
