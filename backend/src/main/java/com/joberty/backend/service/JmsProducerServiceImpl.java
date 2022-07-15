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
import com.joberty.backend.service.interfaces.JmsProducerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class JmsProducerServiceImpl implements JmsProducerService{


    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    ApiTokenRepository tokenRepository;

    @Autowired
    JobOfferRepository jobOfferRepository;

    @Autowired
    ModelMapper modelMapper;

    @Value("${active-mq.send}")
    private String queue;

    public boolean sendJobOffer(Integer jobOfferId,String email){
        ApiToken token=tokenRepository.findByEmail(email);
        System.out.println("token "+token.getToken());
        if(token !=null) {
            JobOffer jobOffer = jobOfferRepository.findById(jobOfferId).get();
            DislinktJobOfferDto dtoJob = modelMapper.map(jobOffer, DislinktJobOfferDto.class);
            JobOffetTokenDto dto = new JobOffetTokenDto(dtoJob, token.getToken());
            try {
                Gson gson = new Gson();
                System.out.println("Sending token");
                jmsTemplate.convertAndSend(queue, gson.toJson(dto));
                return true;
            } catch (Exception e) {
                log.error("Recieved Exception during send Message: ", e);
                return false;
            }
        }else{
            return false;
        }
    }
}
