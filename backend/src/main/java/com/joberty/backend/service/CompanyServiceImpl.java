package com.joberty.backend.service;

import com.joberty.backend.model.Company;
import com.joberty.backend.model.CompanyRegistrationRequest;
import com.joberty.backend.repository.CompanyRepository;
import com.joberty.backend.service.interfaces.CompanyService;
import com.joberty.backend.service.interfaces.RegisteredUserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final RegisteredUserService userService;
    private final ModelMapper modelMapper;

    @Override
    public Company save(CompanyRegistrationRequest companyRequest) {
        Company newCompany = this.modelMapper.map(companyRequest, Company.class);
        this.userService.registerCompany(companyRequest);
        return this.companyRepository.save(newCompany);
    }
}
