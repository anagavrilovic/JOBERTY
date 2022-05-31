package com.joberty.backend.repository;

import com.joberty.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("select c from Comment c where c.company.id = ?1")
    Collection<Comment> findByCompany(Integer companyId);
}
