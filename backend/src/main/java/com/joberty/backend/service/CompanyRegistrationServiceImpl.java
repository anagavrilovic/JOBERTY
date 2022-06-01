package com.joberty.backend.service;

import com.joberty.backend.exception.RegistrationRequestNotFoundException;
import com.joberty.backend.model.CompanyRegistrationRequest;
import com.joberty.backend.repository.CompanyRegistrationRequestRepository;
import com.joberty.backend.service.interfaces.CompanyRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyRegistrationServiceImpl implements CompanyRegistrationService {

    private final CompanyRegistrationRequestRepository companyRegistrationRepository;
    
    @Override
    public List<CompanyRegistrationRequest> getAllRegistrationRequests() {
        return this.companyRegistrationRepository.findAll();
    }

    @Override
    public void approveRegistrationRequest(Integer requestId) {
        CompanyRegistrationRequest request = this.companyRegistrationRepository.findById(requestId).get();
        if(request == null)
            throw new RegistrationRequestNotFoundException();

        //TODO save company as user
        this.companyRegistrationRepository.delete(request);
    }

    @Override
    public void rejectRegistrationRequest(Integer requestId) {
        CompanyRegistrationRequest request = this.companyRegistrationRepository.findById(requestId).get();
        if(request == null)
            throw new RegistrationRequestNotFoundException();

        this.companyRegistrationRepository.delete(request);
    }

    @Override
    public CompanyRegistrationRequest saveRegistrationRequest(CompanyRegistrationRequest request) {
        return this.companyRegistrationRepository.save(request);
    }
}
