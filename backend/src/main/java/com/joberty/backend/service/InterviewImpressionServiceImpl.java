package com.joberty.backend.service;

import com.joberty.backend.dto.InterviewImpressionDto;
import com.joberty.backend.mapper.CustomMapper;
import com.joberty.backend.model.InterviewImpression;
import com.joberty.backend.repository.InterviewImpressionRepository;
import com.joberty.backend.service.interfaces.InterviewImpressionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class InterviewImpressionServiceImpl implements InterviewImpressionService {

    private final InterviewImpressionRepository interviewImpressionRepository;

    @Override
    public InterviewImpression save(InterviewImpressionDto interviewImpressionDto) {
        InterviewImpression impression = CustomMapper.mapInterviewImpression(interviewImpressionDto);
        return interviewImpressionRepository.save(impression);
    }

    @Override
    public Collection<InterviewImpression> findByCompany(Integer companyId) {
        return interviewImpressionRepository.findByCompany(companyId);
    }
}
