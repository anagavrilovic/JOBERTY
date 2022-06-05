package com.joberty.backend.service.interfaces;

import com.joberty.backend.dto.JobOfferDto;
import com.joberty.backend.dto.JobOffetTokenDto;
import com.joberty.backend.model.JobOffer;

import java.util.Collection;

public interface JobOfferService {

    Integer save(JobOfferDto dto);

    Collection<JobOffer> findByCompany(String email);

    Collection<JobOffer> findAll();

    JobOffetTokenDto sendJobOffer(Integer jobOfferId, String email);

}
