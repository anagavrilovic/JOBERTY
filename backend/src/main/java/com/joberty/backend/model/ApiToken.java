package com.joberty.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ApiToken extends BaseEntity{

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime expiringDate;

    @Column(nullable = false)
    private String email;
}
