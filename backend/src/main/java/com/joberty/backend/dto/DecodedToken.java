package com.joberty.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DecodedToken {
    public String username;
    public String role;
    public boolean authorized;
    public String exp;
}
