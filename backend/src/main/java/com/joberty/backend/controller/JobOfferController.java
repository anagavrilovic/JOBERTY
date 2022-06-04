package com.joberty.backend.controller;


import com.joberty.backend.dto.JobOfferDto;
import com.joberty.backend.dto.SalaryInfoDto;
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

@RestController
@RequestMapping(value = "/job-offer", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class JobOfferController {


    private final JobOfferService jobOfferService;
    private final JmsProducerService jmsProducerService;

    @PostMapping("{jobOfferId}/send-token")
    public ResponseEntity<Integer> sendJobOffer(@PathVariable Integer jobOfferId, Principal principal){
            boolean sent= jmsProducerService.sendJobOffer(jobOfferId,principal.getName());
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
}
