package com.joberty.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity implements GrantedAuthority {

    @Column(name="name")
    String name;

    @JsonIgnore
    @Override
    @Column(unique = false, nullable = false)
    public String getAuthority() {
        return null;
    }
}
