package com.joberty.backend.controller;


import com.joberty.backend.dto.JobOfferDto;
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

@RestController
@RequestMapping(value = "/job-offer", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class JobOfferController {


    private final JobOfferService jobOfferService;
    private final JmsProducerService jmsProducerService;

    @PostMapping("{jobOfferId}/send-token/{email}")
    public ResponseEntity<Integer> sendJobOffer(@PathVariable("jobOfferId") Integer jobOfferId,@PathVariable("email") String email){
            boolean sent= jmsProducerService.sendJobOffer(jobOfferId,email);
            if(!sent)  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while sending job offer.");
            return new ResponseEntity<>(jobOfferId, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody JobOfferDto dto){
        try {
            Integer jobOfferId = jobOfferService.save(dto);
            return new ResponseEntity<>(jobOfferId, HttpStatus.CREATED);
        } catch (UnsupportedOperationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There was and error while creating job.");
        }
    }

    @GetMapping("all")
    public ResponseEntity<Collection<JobOffer>> getAll(){
        Collection<JobOffer> jobOffers = jobOfferService.findAll();
        return new ResponseEntity<>(jobOffers, HttpStatus.OK);
    }

    @GetMapping("all/{email}")
    public ResponseEntity<Collection<JobOffer>> getByCompany(@PathVariable String email){
        Collection<JobOffer> jobOffers = jobOfferService.findByCompany(email);
        return new ResponseEntity<>(jobOffers, HttpStatus.OK);
    }
}
