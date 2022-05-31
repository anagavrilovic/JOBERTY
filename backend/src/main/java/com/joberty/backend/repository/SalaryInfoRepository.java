package com.joberty.backend.repository;

import com.joberty.backend.model.Comment;
import com.joberty.backend.model.SalaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface SalaryInfoRepository extends JpaRepository<SalaryInfo, Integer> {

    @Query("select s from SalaryInfo s where s.position.company.id = ?1")
    Collection<SalaryInfo> findByCompany(Integer companyId);
}
