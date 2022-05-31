package com.joberty.backend.repository;

import com.joberty.backend.model.WorkPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPositionRepository extends JpaRepository<WorkPosition, Integer> {
}
