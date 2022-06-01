package com.joberty.backend.service;

import com.joberty.backend.model.Company;
import com.joberty.backend.repository.CompanyRepository;
import com.joberty.backend.service.interfaces.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;
import com.joberty.backend.model.CompanyRegistrationRequest;
import com.joberty.backend.service.interfaces.RegisteredUserService;
import org.modelmapper.ModelMapper;


@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final RegisteredUserService userService;
    private final ModelMapper modelMapper;

    @Override
    public Collection<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company save(CompanyRegistrationRequest companyRequest) {
        Company newCompany = this.modelMapper.map(companyRequest, Company.class);
        newCompany.setId(null);
        this.userService.registerCompany(companyRequest);
        return this.companyRepository.save(newCompany);
    }
}
