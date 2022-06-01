package com.joberty.backend.service.interfaces;

import com.joberty.backend.model.Company;

import java.util.Collection;

public interface CompanyService {
    Collection<Company> findAll();
}
