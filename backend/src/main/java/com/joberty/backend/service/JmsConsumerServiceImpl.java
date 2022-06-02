package com.joberty.backend.service;

import com.joberty.backend.dto.DecodedToken;
import com.joberty.backend.model.ApiToken;
import com.joberty.backend.model.RegisteredUser;
import com.joberty.backend.repository.ApiTokenRepository;
import com.joberty.backend.repository.RegisteredUserRepository;
import com.joberty.backend.service.interfaces.JmsConsumerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class JmsConsumerServiceImpl implements JmsConsumerService {

    private final ApiTokenRepository tokenRepository;
    private final RegisteredUserRepository userRepository;
    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message messageReceived) {
        try{
            if (messageReceived instanceof TextMessage) {
                TextMessage objectMessage = (TextMessage) messageReceived;
                System.out.println("Message received " + objectMessage.getText());
                String token = objectMessage.getText();
                if (tokenIsValid(token)) {
                    ApiToken apiToken = new ApiToken(token, LocalDateTime.now().plusHours(1));
                    tokenRepository.save(apiToken);
               }
            }
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }
    }

    private boolean tokenIsValid(String token) {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
//      String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        DecodedToken tokenData=new Gson().fromJson(payload, DecodedToken.class);
        System.out.println("Email :"+tokenData.getUsername());
        RegisteredUser user=userRepository.findByEmail(tokenData.getUsername());
        if(user == null && !user.getRole().getName().equals("ROLE_COMPANY_OWNER")) return false;
        return true;
    }
}
