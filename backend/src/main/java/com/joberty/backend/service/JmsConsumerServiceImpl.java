package com.joberty.backend.service;

import com.joberty.backend.dto.DecodedToken;
import com.joberty.backend.model.ApiToken;
import com.joberty.backend.model.RegisteredUser;
import com.joberty.backend.repository.ApiTokenRepository;
import com.joberty.backend.repository.RegisteredUserRepository;
import com.joberty.backend.service.interfaces.JmsConsumerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQBytesMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import javax.jms.Message;
import javax.jms.Session;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@Slf4j
@AllArgsConstructor
public class JmsConsumerServiceImpl implements JmsConsumerService {

    private final ApiTokenRepository tokenRepository;
    private final RegisteredUserRepository userRepository;

    @JmsListener(destination = "${active-mq.queue}")
    public void receiveMessage(@Headers MessageHeaders headers, Message messageReceived, Session session) {
        System.out.println("received queue");
        try{
            System.out.println(messageReceived);
            ActiveMQBytesMessage messageInBytes = (ActiveMQBytesMessage) messageReceived;
            byte[] byteArr = new byte[(int)messageInBytes.getBodyLength()];
            messageInBytes.readBytes(byteArr);
            String token = new String(byteArr, "UTF-8");
            System.out.println(token);
            RegisteredUser user =getUserFromToken(token);
            if (user != null) {
                ApiToken apiToken = new ApiToken(token, LocalDateTime.now().plusHours(1),user.getEmail());
                tokenRepository.save(apiToken);
            }
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }
    }

    @Override
    @JmsListener(destination = "${active-mq.queue}")
    public void onMessage(Message messageReceived) {
        System.out.println("received topic");
        try{
            System.out.println(messageReceived);
            ActiveMQBytesMessage messageInBytes = (ActiveMQBytesMessage) messageReceived;
            byte[] byteArr = new byte[(int)messageInBytes.getBodyLength()];
            messageInBytes.readBytes(byteArr);
            String token = new String(byteArr, "UTF-8");
            System.out.println(token);
            RegisteredUser user =getUserFromToken(token);
            ApiToken deleted= tokenRepository.findByEmail(user.getEmail());
            if(deleted != null) tokenRepository.delete(deleted);
            if (user != null) {
                ApiToken apiToken = new ApiToken(token, LocalDateTime.now().plusHours(1),user.getEmail());
                tokenRepository.save(apiToken);
            }
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }
    }

    private RegisteredUser getUserFromToken(String token) {
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
//      String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        DecodedToken tokenData=new Gson().fromJson(payload, DecodedToken.class);
        System.out.println("Email :"+tokenData.getEmail());
        RegisteredUser user=userRepository.findByEmail(tokenData.getEmail());
        if(user == null && !user.getRole().getName().equals("ROLE_COMPANY_OWNER")) return null;
        return user;
    }
}