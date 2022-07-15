package com.joberty.backend.dto;

import com.joberty.backend.model.Gender;
import com.joberty.backend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisteredUserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
    private boolean enabled;
    private Role role;
}
