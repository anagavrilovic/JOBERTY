package com.joberty.backend.controller;

import com.joberty.backend.dto.CompanyDto;
import com.joberty.backend.dto.SalaryInfoDto;
import com.joberty.backend.model.Comment;
import com.joberty.backend.model.Company;
import com.joberty.backend.model.SalaryInfo;
import com.joberty.backend.service.interfaces.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
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

    @GetMapping("/{email}")
    public ResponseEntity<Company> getByEmail(@PathVariable String email){
        Company company = companyService.getByEmail(email);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/owner")
    public ResponseEntity<Company> getByOwner(Principal principal){
        Company company = companyService.getByEmail(principal.getName());
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Company company){
        try {
            companyService.update(company);
            return new ResponseEntity<>("Successfully updated. ", HttpStatus.OK);
        } catch (UnsupportedOperationException e) {
            return new ResponseEntity<>("Company does not exist. ", HttpStatus.BAD_REQUEST);
        }
    }
}
