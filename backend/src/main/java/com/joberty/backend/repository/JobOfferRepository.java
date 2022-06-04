package com.joberty.backend.repository;

import com.joberty.backend.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferRepository  extends JpaRepository<JobOffer,Integer> {
}
