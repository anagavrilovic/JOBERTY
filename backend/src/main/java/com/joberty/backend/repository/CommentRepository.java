package com.joberty.backend.repository;

import com.joberty.backend.dto.CompanyCommentDto;
import com.joberty.backend.dto.CompanyDto;
import com.joberty.backend.model.Comment;
import com.joberty.backend.model.InterviewImpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("select c from Comment c where c.company.id = ?1")
    Collection<Comment> findByCompany(Integer companyId);

    @Query("select c from Comment c where c.company.id = ?1 and c.user.id = ?2 ")
    Collection<Comment> findCommentsByUserAndCompany(Integer companyId, Integer userId);

    @Query("select new com.joberty.backend.dto.CompanyCommentDto(avg(c.mark), count(c.mark)) " +
            "from Comment as c " +
            "where c.company.id = ?1 " +
            "group by c.company.id")
    CompanyCommentDto findCommentDataOfCompany(Integer companyId);
}
