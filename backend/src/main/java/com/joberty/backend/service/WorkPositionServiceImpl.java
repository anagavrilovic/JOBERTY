package com.joberty.backend.service;

import com.joberty.backend.model.WorkPosition;
import com.joberty.backend.repository.WorkPositionRepository;
import com.joberty.backend.service.interfaces.WorkPositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class WorkPositionServiceImpl implements WorkPositionService {

    private final WorkPositionRepository workPositionRepository;

    @Override
    public Collection<WorkPosition> findWorkPositionsByCompany(Integer companyId) {
        return workPositionRepository.findByCompany(companyId);
    }
}
