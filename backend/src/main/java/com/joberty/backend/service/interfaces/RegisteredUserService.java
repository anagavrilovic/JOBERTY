package com.joberty.backend.service.interfaces;

import com.joberty.backend.dto.RegisteredUserDto;
import com.joberty.backend.model.CompanyRegistrationRequest;

public interface RegisteredUserService {

    RegisteredUserDto registerUser(RegisteredUserDto userDTO);

    RegisteredUserDto saveUser(RegisteredUserDto userDTO);

    void registerCompany(CompanyRegistrationRequest companyRequest);

    RegisteredUserDto getUserByUsername(String username);
}
