package com.joberty.backend.repository;

import com.joberty.backend.model.ApiToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiTokenRepository extends JpaRepository<ApiToken, Integer> {

}
