package com.joberty.backend.controller;


import com.joberty.backend.dto.JobOfferDto;
import com.joberty.backend.dto.JobOffetTokenDto;
import com.joberty.backend.dto.SalaryInfoDto;
import com.joberty.backend.model.JobOffer;
import com.joberty.backend.model.SalaryInfo;
import com.joberty.backend.service.interfaces.JmsProducerService;
import com.joberty.backend.service.interfaces.JobOfferService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Collection;

import static com.joberty.backend.JobertyApplication.LOGGER_ERROR;
import static com.joberty.backend.JobertyApplication.LOGGER_INFO;

@RestController
@RequestMapping(value = "/job-offer", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class JobOfferController {


    private final JobOfferService jobOfferService;

    @PostMapping("{jobOfferId}/send-token/{email}")
    public ResponseEntity<JobOffetTokenDto> sendJobOffer(@PathVariable("jobOfferId") Integer jobOfferId,@PathVariable("email") String email){
            JobOffetTokenDto dto= jobOfferService.sendJobOffer(jobOfferId,email);
            if(dto ==null)  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while sending job offer.");
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody JobOfferDto dto){
        try {
            Integer jobOfferId = jobOfferService.save(dto);
            LOGGER_INFO.info("User: " + dto.getCompany().getEmail() +  " | Action: CJO");
            return new ResponseEntity<>(jobOfferId, HttpStatus.CREATED);
        } catch (UnsupportedOperationException e) {
            LOGGER_ERROR.error("User: " + dto.getCompany().getEmail() +  " | Action: CJO");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There was and error while creating job.");
        }
    }

    @GetMapping("all")
    public ResponseEntity<Collection<JobOffer>> getAll(){
        Collection<JobOffer> jobOffers = jobOfferService.findAll();
        LOGGER_INFO.info("Action: JO");
        return new ResponseEntity<>(jobOffers, HttpStatus.OK);
    }

    @GetMapping("all/{email}")
    public ResponseEntity<Collection<JobOffer>> getByCompany(@PathVariable String email){
        Collection<JobOffer> jobOffers = jobOfferService.findByCompany(email);
        LOGGER_INFO.info("Action: JO/:c");
        return new ResponseEntity<>(jobOffers, HttpStatus.OK);
    }
}
