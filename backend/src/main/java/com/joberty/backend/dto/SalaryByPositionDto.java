package com.joberty.backend.dto;

import com.joberty.backend.model.FormOfEmployment;
import com.joberty.backend.model.Seniority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryByPositionDto {
    private String title;
    private FormOfEmployment formOfEmployment;
    private Seniority seniority;
    private double minSalary;
    private double maxSalary;
    private Double avgSalary;
    private Long numberOfSalaries;
}
