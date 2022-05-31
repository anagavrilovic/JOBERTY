package com.joberty.backend.service;

import com.joberty.backend.dto.RegisteredUserDto;
import com.joberty.backend.model.RegisteredUser;
import com.joberty.backend.model.Role;
import com.joberty.backend.repository.RegisteredUserRepository;
import com.joberty.backend.service.interfaces.RegisteredUserService;
import com.joberty.backend.service.interfaces.RoleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisteredUserServiceImpl implements RegisteredUserService {

    private final RegisteredUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    @Override
    public RegisteredUserDto registerUser(RegisteredUserDto userDTO) {
        RegisteredUser newUser = modelMapper.map(userDTO, RegisteredUser.class);
        Role role = roleService.findOneByName("ROLE_USER");
        newUser.setRole(role);
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setEnabled(true);
        this.userRepository.save(newUser);
        return userDTO;
    }

    @Override
    public RegisteredUserDto saveUser(RegisteredUserDto userDTO) {
        RegisteredUser user = modelMapper.map(userDTO, RegisteredUser.class);
        this.userRepository.save(user);
        return userDTO;
    }
}
