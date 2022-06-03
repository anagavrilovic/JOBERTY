package com.joberty.backend.service;

import com.joberty.backend.dto.CommentDto;
import com.joberty.backend.mapper.CustomMapper;
import com.joberty.backend.model.Comment;
import com.joberty.backend.repository.CommentRepository;
import com.joberty.backend.service.interfaces.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment save(CommentDto commentDto) throws UnsupportedOperationException {
        Comment comment = CustomMapper.mapComment(commentDto);

        Collection<Comment> commentsByUserAndCompany = commentRepository.findCommentsByUserAndCompany(
                comment.getCompany().getId(),
                comment.getUser().getId()
        );

        if(commentsByUserAndCompany.size() > 0) throw new UnsupportedOperationException();

        return commentRepository.save(comment);
    }

    @Override
    public Collection<Comment> findByCompany(Integer companyId) {
        return commentRepository.findByCompany(companyId);
    }
}
