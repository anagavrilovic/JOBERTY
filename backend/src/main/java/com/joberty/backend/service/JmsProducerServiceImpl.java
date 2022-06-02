package com.joberty.backend.service;

import com.joberty.backend.dto.JobOffetTokenDto;
import com.joberty.backend.model.ApiToken;
import com.joberty.backend.model.JobOffer;
import com.joberty.backend.repository.ApiTokenRepository;
import com.joberty.backend.service.interfaces.JmsProducerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Value("${active-mq.send}")
    private String topic;

    public boolean sendJobOffer(JobOffer jobOffer,String email){
        ApiToken token=tokenRepository.findByEmail(email);
        if(token !=null && token.getExpiringDate().isBefore(LocalDateTime.now())) {
            JobOffetTokenDto dto = new JobOffetTokenDto(jobOffer, token.getToken());
            try {
                jmsTemplate.convertAndSend(topic, dto);
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
