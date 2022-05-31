package com.joberty.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTokenState {
    private String accessToken;
    private Integer expiresIn;
    private String role;
}
