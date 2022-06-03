package com.joberty.backend.controller;

import com.joberty.backend.dto.CompanyDto;
import com.joberty.backend.model.Comment;
import com.joberty.backend.model.Company;
import com.joberty.backend.service.interfaces.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/all")
    public ResponseEntity<Collection<CompanyDto>> findAll(){
        Collection<CompanyDto> companies = companyService.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }
}
