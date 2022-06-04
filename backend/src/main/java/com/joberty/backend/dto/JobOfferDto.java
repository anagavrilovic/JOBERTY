package com.joberty.backend.dto;


import com.joberty.backend.model.Company;
import com.joberty.backend.model.FormOfEmployment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobOfferDto {
    private Company company;
    private String position;
    private String jobDescription;
    private String prerequisites;
    private FormOfEmployment employment_type;
}
