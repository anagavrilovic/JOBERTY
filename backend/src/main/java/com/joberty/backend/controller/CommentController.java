package com.joberty.backend.controller;

import com.joberty.backend.dto.CommentDto;
import com.joberty.backend.model.Comment;
import com.joberty.backend.service.interfaces.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/comment", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody CommentDto commentDto){
        Comment comment = commentService.save(commentDto);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Collection<Comment>> findByCompany(@PathVariable(name="id") Integer id){
        Collection<Comment> comments = commentService.findByCompany(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

}
