package com.joberty.backend.repository;

import com.joberty.backend.model.JobOffer;
import com.joberty.backend.model.SalaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface JobOfferRepository  extends JpaRepository<JobOffer,Integer> {

    @Query("select j from JobOffer j where j.company.email = ?1")
    Collection<JobOffer> findByCompany(String email);
}
