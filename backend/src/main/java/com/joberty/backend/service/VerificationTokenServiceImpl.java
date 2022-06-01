package com.joberty.backend.service;

import com.joberty.backend.model.VerificationToken;
import com.joberty.backend.repository.VerificationTokenRepository;
import com.joberty.backend.service.interfaces.VerificationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;

    public void createVerificationToken(String token) {
        VerificationToken myToken = VerificationToken.builder().token(token).build();
        verificationTokenRepository.save(myToken);
    }

    public VerificationToken findByToken(String name){ return verificationTokenRepository.findByToken(name); }

    public void save(VerificationToken verificationToken) { verificationTokenRepository.save(verificationToken); }
}
