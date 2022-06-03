package com.joberty.backend.controller;

import com.joberty.backend.dto.CommentDto;
import com.joberty.backend.dto.InterviewImpressionDto;
import com.joberty.backend.model.Comment;
import com.joberty.backend.model.InterviewImpression;
import com.joberty.backend.service.interfaces.InterviewImpressionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
@RequestMapping(value = "/interview", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class InterviewImpressionController {

    private final InterviewImpressionService interviewImpressionService;

    @PostMapping
    public ResponseEntity<InterviewImpression> saveInterviewImpression(@RequestBody InterviewImpressionDto interviewImpressionDto){
        try {
            InterviewImpression interviewImpression = interviewImpressionService.save(interviewImpressionDto);
            return new ResponseEntity<>(interviewImpression, HttpStatus.CREATED);
        } catch (UnsupportedOperationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You already left impression for this work position.");
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Collection<InterviewImpression>> findByCompany(@PathVariable(name="id") Integer id){
        Collection<InterviewImpression> impressions = interviewImpressionService.findByCompany(id);
        return new ResponseEntity<>(impressions, HttpStatus.OK);
    }
}
