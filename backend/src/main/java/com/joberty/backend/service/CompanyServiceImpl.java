package com.joberty.backend.service;

import com.joberty.backend.model.Company;
import com.joberty.backend.repository.CompanyRepository;
import com.joberty.backend.service.interfaces.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;


    @Override
    public Collection<Company> findAll() {
        return companyRepository.findAll();
    }
}
