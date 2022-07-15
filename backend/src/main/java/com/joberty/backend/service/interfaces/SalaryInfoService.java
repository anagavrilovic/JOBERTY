package com.joberty.backend.service.interfaces;

import com.joberty.backend.dto.SalaryByPositionDto;
import com.joberty.backend.dto.SalaryInfoDto;
import com.joberty.backend.model.SalaryInfo;

import java.util.Collection;

public interface SalaryInfoService {
    SalaryInfo save(SalaryInfoDto dto);
    Collection<SalaryByPositionDto> findByCompany(Integer companyId);
}
