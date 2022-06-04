package com.joberty.backend.repository;

import com.joberty.backend.model.ApiToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ApiTokenRepository extends JpaRepository<ApiToken, Integer> {

    @Query("select token from ApiToken token where token.email = ?1 and token.expiringDate <= ?2")
    ApiToken findByEmailAndExpiringDate(String email, LocalDateTime dateTime);
}
