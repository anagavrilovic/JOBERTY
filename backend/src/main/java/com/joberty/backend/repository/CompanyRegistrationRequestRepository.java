package com.joberty.backend.repository;

import com.joberty.backend.model.CompanyRegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRegistrationRequestRepository extends JpaRepository<CompanyRegistrationRequest, Integer> {
}
