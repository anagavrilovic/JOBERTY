package com.joberty.backend.service.interfaces;

import com.joberty.backend.model.Company;
import com.joberty.backend.model.CompanyRegistrationRequest;

public interface CompanyService {

    Company save(CompanyRegistrationRequest companyRequest);
}
