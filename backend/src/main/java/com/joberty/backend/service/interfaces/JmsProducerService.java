package com.joberty.backend.service.interfaces;

import com.joberty.backend.model.JobOffer;

public interface JmsProducerService {

    boolean sendJobOffer(JobOffer jobOffer, String email);
}
