package com.joberty.backend.service;

import com.joberty.backend.dto.SalaryInfoDto;
import com.joberty.backend.mapper.CustomMapper;
import com.joberty.backend.model.SalaryInfo;
import com.joberty.backend.repository.SalaryInfoRepository;
import com.joberty.backend.service.interfaces.SalaryInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class SalaryInfoServiceImpl implements SalaryInfoService {

    private final SalaryInfoRepository salaryInfoRepository;

    @Override
    public SalaryInfo save(SalaryInfoDto salaryInfoDto) {
        SalaryInfo salaryInfo = CustomMapper.mapSalaryInfo(salaryInfoDto);
        return salaryInfoRepository.save(salaryInfo);
    }

    @Override
    public Collection<SalaryInfo> findByCompany(Integer companyId) {
        return salaryInfoRepository.findByCompany(companyId);
    }
}
