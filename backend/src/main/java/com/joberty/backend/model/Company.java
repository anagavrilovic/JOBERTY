package com.joberty.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String description;

    @Column
    private String website;

    @Column
    private int size;

    @Column
    private String industry;
}
