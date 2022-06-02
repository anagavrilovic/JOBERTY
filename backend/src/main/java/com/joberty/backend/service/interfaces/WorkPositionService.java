package com.joberty.backend.service.interfaces;

import com.joberty.backend.model.WorkPosition;

import java.util.Collection;

public interface WorkPositionService {
    Collection<WorkPosition> findWorkPositionsByCompany(Integer companyId);
}
