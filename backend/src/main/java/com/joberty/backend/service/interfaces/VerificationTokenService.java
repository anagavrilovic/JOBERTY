package com.joberty.backend.service.interfaces;

import com.joberty.backend.model.VerificationToken;

public interface VerificationTokenService {

    void createVerificationToken(String token);
    VerificationToken findByToken(String name);
    void save(VerificationToken verificationToken);
}
