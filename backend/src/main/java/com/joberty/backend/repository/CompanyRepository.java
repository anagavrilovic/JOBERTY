package com.joberty.backend.repository;

import com.joberty.backend.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByEmail(String email);
}
