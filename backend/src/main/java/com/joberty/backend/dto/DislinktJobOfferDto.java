package com.joberty.backend.dto;

import com.joberty.backend.model.Company;
import com.joberty.backend.model.FormOfEmployment;
import com.joberty.backend.model.Seniority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DislinktJobOfferDto {
    private Company company;
    private String position;
    private String jobDescription;
    private String prerequisites;
    private FormOfEmployment employment_type;
}
