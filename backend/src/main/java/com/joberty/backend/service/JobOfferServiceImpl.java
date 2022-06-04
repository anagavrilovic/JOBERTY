package com.joberty.backend.service;

import com.joberty.backend.dto.JobOfferDto;
import com.joberty.backend.model.JobOffer;
import com.joberty.backend.model.RegisteredUser;
import com.joberty.backend.repository.JobOfferRepository;
import com.joberty.backend.service.interfaces.JobOfferService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class JobOfferServiceImpl implements JobOfferService {

    private final ModelMapper modelMapper;
    private final JobOfferRepository jobOfferRepository;

    @Override
    public Integer save(JobOfferDto dto) {
        JobOffer newJobOffer = modelMapper.map(dto, JobOffer.class);
        newJobOffer.setPublished(new Date());
        JobOffer offer=jobOfferRepository.save(newJobOffer);
        if(offer ==null) throw new UnsupportedOperationException();
        return offer.getId();
    }
}
