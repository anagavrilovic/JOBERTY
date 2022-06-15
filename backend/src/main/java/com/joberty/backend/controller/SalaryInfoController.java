package com.joberty.backend.controller;

import com.joberty.backend.dto.CommentDto;
import com.joberty.backend.dto.SalaryByPositionDto;
import com.joberty.backend.dto.SalaryInfoDto;
import com.joberty.backend.model.Comment;
import com.joberty.backend.model.SalaryInfo;
import com.joberty.backend.service.interfaces.SalaryInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

import static com.joberty.backend.JobertyApplication.LOGGER_ERROR;
import static com.joberty.backend.JobertyApplication.LOGGER_INFO;

@RestController
@RequestMapping(value = "/salary", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SalaryInfoController {

    private final SalaryInfoService salaryInfoService;

    @PostMapping
    public ResponseEntity<SalaryInfo> saveSalaryInfo(@RequestBody SalaryInfoDto salaryDto){
        try {
            SalaryInfo salaryInfo = salaryInfoService.save(salaryDto);
            LOGGER_INFO.info("User: " + salaryDto.getUserId() + " | Action: CSI");
            return new ResponseEntity<>(salaryInfo, HttpStatus.CREATED);
        } catch (UnsupportedOperationException e) {
            LOGGER_ERROR.error("User: " + salaryDto.getUserId() + " | Action: CSI");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You already left salary info for this position.");
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Collection<SalaryByPositionDto>> findByCompany(@PathVariable(name="id") Integer id){
        Collection<SalaryByPositionDto> salaries = salaryInfoService.findByCompany(id);
        LOGGER_INFO.info("Action: S/:c");
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }
}
