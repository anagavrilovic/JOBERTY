package com.joberty.backend.service;

import com.joberty.backend.dto.SalaryByPositionDto;
import com.joberty.backend.dto.SalaryInfoDto;
import com.joberty.backend.mapper.CustomMapper;
import com.joberty.backend.model.SalaryInfo;
import com.joberty.backend.repository.SalaryInfoRepository;
import com.joberty.backend.service.interfaces.SalaryInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class SalaryInfoServiceImpl implements SalaryInfoService {

    private final SalaryInfoRepository salaryInfoRepository;

    @Override
    public SalaryInfo save(SalaryInfoDto salaryInfoDto) throws UnsupportedOperationException {
        SalaryInfo salaryInfo = CustomMapper.mapSalaryInfo(salaryInfoDto);

        Collection<SalaryInfo> salariesByPosition = salaryInfoRepository.findSalaryInfoByPosition(
                salaryInfo.getPosition().getId(),
                salaryInfo.getUser().getId());

        if(salariesByPosition.size() > 0) throw new UnsupportedOperationException();

        return salaryInfoRepository.save(salaryInfo);
    }

    @Override
    public Collection<SalaryByPositionDto> findByCompany(Integer companyId) {
        return salaryInfoRepository.findSalariesInfoInCompanyByPosition(companyId);
    }
}
