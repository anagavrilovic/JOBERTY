package com.joberty.backend.service;

import com.joberty.backend.model.RegisteredUser;
import com.joberty.backend.repository.RegisteredUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final RegisteredUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RegisteredUser user = userRepository.findByEmail(username);
        if(user == null)
            throw new UsernameNotFoundException(username);

        return user;
    }
}
