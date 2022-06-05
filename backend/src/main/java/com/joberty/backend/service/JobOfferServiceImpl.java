package com.joberty.backend.service;

import com.google.gson.Gson;
import com.joberty.backend.dto.DislinktJobOfferDto;
import com.joberty.backend.dto.JobOfferDto;
import com.joberty.backend.dto.JobOffetTokenDto;
import com.joberty.backend.model.ApiToken;
import com.joberty.backend.model.JobOffer;
import com.joberty.backend.model.RegisteredUser;
import com.joberty.backend.repository.ApiTokenRepository;
import com.joberty.backend.repository.JobOfferRepository;
import com.joberty.backend.service.interfaces.JobOfferService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@Service
public class JobOfferServiceImpl implements JobOfferService {

    private final ModelMapper modelMapper;
    private final JobOfferRepository jobOfferRepository;
    private final ApiTokenRepository tokenRepository;
    private final RestTemplate restTemplate;

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
    public boolean sendJobOffer(Integer jobOfferId,String email){
        ApiToken token=tokenRepository.findByEmail(email);
        System.out.println("token "+token.getToken());
        if(token !=null) {
            JobOffer jobOffer = jobOfferRepository.findById(jobOfferId).get();
            DislinktJobOfferDto dtoJob = modelMapper.map(jobOffer, DislinktJobOfferDto.class);
            JobOffetTokenDto dto = new JobOffetTokenDto(dtoJob, token.getToken());
            Gson gson = new Gson();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request =
                    new HttpEntity<>(gson.toJson(dto), headers);
            restTemplate.postForObject("https://localhost:8083/receive-job-offer", request, boolean.class);
            System.out.println("Sending token");
            return true;
        }else{
            return false;
        }
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
