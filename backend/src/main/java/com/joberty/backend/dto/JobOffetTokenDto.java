package com.joberty.backend.dto;

import com.joberty.backend.model.JobOffer;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JobOffetTokenDto {
    private JobOffer jobOffer;
    private String token;
}
