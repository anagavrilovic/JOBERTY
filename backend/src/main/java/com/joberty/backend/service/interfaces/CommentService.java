package com.joberty.backend.service.interfaces;

import com.joberty.backend.dto.CommentDto;
import com.joberty.backend.model.Comment;

import java.util.Collection;

public interface CommentService {
    Comment save(CommentDto commentDto);
    Collection<Comment> findByCompany(Integer companyId);
}
