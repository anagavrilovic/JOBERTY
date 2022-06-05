package com.joberty.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobOffer extends BaseEntity{

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String jobDescription;

    @Column(nullable = false)
    private String prerequisites;

    @Column(nullable = false)
    private FormOfEmployment employment_type;

    private Date published;

    private Date expires;

    private Seniority seniority;
}
