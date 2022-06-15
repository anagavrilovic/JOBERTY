package com.joberty.backend.controller;

import com.joberty.backend.model.Comment;
import com.joberty.backend.model.WorkPosition;
import com.joberty.backend.service.interfaces.WorkPositionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static com.joberty.backend.JobertyApplication.LOGGER_INFO;

@RestController
@RequestMapping(value = "/position", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class WorkPositionController {

    private final WorkPositionService workPositionService;

    @GetMapping("/all/{id}")
    public ResponseEntity<Collection<WorkPosition>> findByCompany(@PathVariable(name="id") Integer id){
        Collection<WorkPosition> positions = workPositionService.findWorkPositionsByCompany(id);
        LOGGER_INFO.info("Action: WP/:c");
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }
}
