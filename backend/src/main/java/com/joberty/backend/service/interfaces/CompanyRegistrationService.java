package com.joberty.backend.service.interfaces;

import com.joberty.backend.model.CompanyRegistrationRequest;

import java.util.List;

public interface CompanyRegistrationService {

    List<CompanyRegistrationRequest> getAllRegistrationRequests();

    void approveRegistrationRequest(Integer requestId);

    void rejectRegistrationRequest(Integer requestId);

    CompanyRegistrationRequest saveRegistrationRequest(CompanyRegistrationRequest request);
}
