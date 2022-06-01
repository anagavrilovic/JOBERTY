package com.joberty.backend.repository;

import com.joberty.backend.model.VerificationToken;
import org.springframework.data.repository.CrudRepository;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, String> {

    VerificationToken findByToken(String token);
}
