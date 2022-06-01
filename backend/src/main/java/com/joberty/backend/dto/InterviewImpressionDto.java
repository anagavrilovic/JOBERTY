package com.joberty.backend.dto;

import com.joberty.backend.model.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewImpressionDto {
    private Integer positionId;
    private Integer userId;
    private OfferStatus offerStatus;
    private String technicalInterviewImpression;
    private String hrInterviewImpression;
    private String caption;
    private double mark;
}
