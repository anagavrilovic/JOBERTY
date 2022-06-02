package com.joberty.backend.service;

import com.joberty.backend.service.interfaces.JmsProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsProducerServiceImpl extends JmsProducerService{

    @Autowired
    JmsTemplate jmsTemplate;


    @Value("${active-mq.send}")
    private String topic;
    public void sendJobOffer(){
        try{
            jmsTemplate.convertAndSend(topic, "");
        } catch(Exception e){
            log.error("Recieved Exception during send Message: ", e);
        }
    }
}
