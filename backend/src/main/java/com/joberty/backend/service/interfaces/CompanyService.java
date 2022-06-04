package com.joberty.backend.service.interfaces;

import com.joberty.backend.dto.CompanyDto;
import com.joberty.backend.model.Company;
import com.joberty.backend.model.CompanyRegistrationRequest;

import java.util.Collection;

public interface CompanyService {

    Collection<CompanyDto> findAll();

    Company save(CompanyRegistrationRequest companyRequest);

    Company getByEmail(String email);
}
