package com.joberty.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryInfoDto {
    private Integer positionId;
    private Integer userId;
    private double amountInEur;
}
