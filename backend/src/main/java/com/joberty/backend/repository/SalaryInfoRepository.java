package com.joberty.backend.repository;

import com.joberty.backend.dto.SalaryByPositionDto;
import com.joberty.backend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SalaryInfoRepository extends JpaRepository<SalaryInfo, Integer> {

    @Query("select s from SalaryInfo s where s.position.company.id = ?1")
    Collection<SalaryInfo> findByCompany(Integer companyId);

    @Query("select distinct new com.joberty.backend.dto.SalaryByPositionDto(s.position.title, s.position.formOfEmployment, s.position.seniority," +
            "min(s.amountInEur), max(s.amountInEur), avg(s.amountInEur), count(s.amountInEur))" +
            "from SalaryInfo as s " +
            "where s.position.company.id = ?1 " +
            "group by s.position.title, s.position.formOfEmployment, s.position.seniority")
    Collection<SalaryByPositionDto> findSalariesInfoInCompanyByPosition(Integer companyId);

    @Query("select s from SalaryInfo s where s.position.id = ?1 and s.user.id = ?2 ")
    Collection<SalaryInfo> findSalaryInfoByPosition(Integer positionId, Integer userId);
}
