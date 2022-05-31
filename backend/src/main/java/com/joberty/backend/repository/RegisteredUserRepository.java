package com.joberty.backend.repository;

import com.joberty.backend.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {

    RegisteredUser findByEmail(String email);
}
