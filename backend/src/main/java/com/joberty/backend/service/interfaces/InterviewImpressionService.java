package com.joberty.backend.service.interfaces;

import com.joberty.backend.dto.InterviewImpressionDto;
import com.joberty.backend.model.InterviewImpression;

import java.util.Collection;

public interface InterviewImpressionService {
    InterviewImpression save(InterviewImpressionDto interviewImpressionDto);
    Collection<InterviewImpression> findByCompany(Integer companyId);
}
