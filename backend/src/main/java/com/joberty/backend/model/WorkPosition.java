package com.joberty.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkPosition extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private FormOfEmployment formOfEmployment;
}
