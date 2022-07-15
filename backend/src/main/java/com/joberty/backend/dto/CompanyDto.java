package com.joberty.backend.dto;

import com.joberty.backend.model.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {
    Company company;
    double companyRate;
    Long numberOfComments;
}
