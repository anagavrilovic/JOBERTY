package com.joberty.backend.service;

import com.joberty.backend.dto.JobOfferDto;
import com.joberty.backend.model.JobOffer;
import com.joberty.backend.model.RegisteredUser;
import com.joberty.backend.repository.JobOfferRepository;
import com.joberty.backend.service.interfaces.JobOfferService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
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
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 2); //minus number would decrement the days
        Date expires = cal.getTime();
        newJobOffer.setExpires(expires);
        JobOffer offer=jobOfferRepository.save(newJobOffer);
        if(offer ==null) throw new UnsupportedOperationException();
        return offer.getId();
    }

    @Override
    public Collection<JobOffer> findByCompany(String email) {
        return jobOfferRepository.findByCompany(email);
    }

    @Override
    public Collection<JobOffer> findAll() {
        return jobOfferRepository.findAll();
    }
}
