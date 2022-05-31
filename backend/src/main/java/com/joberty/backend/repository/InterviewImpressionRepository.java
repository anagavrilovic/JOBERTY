package com.joberty.backend.repository;

import com.joberty.backend.model.InterviewImpression;
import com.joberty.backend.model.SalaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface InterviewImpressionRepository extends JpaRepository<InterviewImpression, Integer> {

    @Query("select i from InterviewImpression i where i.position.company.id = ?1")
    Collection<InterviewImpression> findByCompany(Integer companyId);

}
