package com.joberty.backend.service;

import com.joberty.backend.dto.CompanyCommentDto;
import com.joberty.backend.dto.CompanyDto;
import com.joberty.backend.model.Company;
import com.joberty.backend.repository.CommentRepository;
import com.joberty.backend.repository.CompanyRepository;
import com.joberty.backend.service.interfaces.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import com.joberty.backend.model.CompanyRegistrationRequest;
import com.joberty.backend.service.interfaces.RegisteredUserService;
import org.modelmapper.ModelMapper;


@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CommentRepository commentRepository;
    private final RegisteredUserService userService;
    private final ModelMapper modelMapper;

    @Override
    public Collection<CompanyDto> findAll() {
        Collection<Company> companies = companyRepository.findAll();
        
        Collection<CompanyDto> companyDtos = new ArrayList<>();
        for (Company c : companies) {
            CompanyCommentDto companyComment = commentRepository.findCommentDataOfCompany(c.getId());

            CompanyDto dto;
            if(companyComment != null) dto = new CompanyDto(c, companyComment.getCompanyRate(), companyComment.getNumberOfComments());
            else dto = new CompanyDto(c, 0, 0l);
            companyDtos.add(dto);
        }
        
        return companyDtos;
    }

    @Override
    public Company save(CompanyRegistrationRequest companyRequest) {
        Company newCompany = this.modelMapper.map(companyRequest, Company.class);
        newCompany.setId(null);
        this.userService.registerCompany(companyRequest);
        return this.companyRepository.save(newCompany);
    }

    @Override
    public Company getByEmail(String email) {
        return companyRepository.findByEmail(email);
    }

    @Override
    public Company update(Company company) throws UnsupportedOperationException{
        Company dbCompany = companyRepository.findByEmail(company.getEmail());

        if(dbCompany == null){
            throw new UnsupportedOperationException("Company does not exist.");
        }

        company.setId(dbCompany.getId());

        return companyRepository.save(company);
    }
}
