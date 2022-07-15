package com.joberty.backend.repository;

import com.joberty.backend.model.SalaryInfo;
import com.joberty.backend.model.WorkPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface WorkPositionRepository extends JpaRepository<WorkPosition, Integer> {

    @Query("select p from WorkPosition p where p.company.id = ?1")
    Collection<WorkPosition> findByCompany(Integer companyId);
}
