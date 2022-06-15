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

import static com.joberty.backend.JobertyApplication.LOGGER_ERROR;
import static com.joberty.backend.JobertyApplication.LOGGER_INFO;

@RestController
@RequestMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/all")
    public ResponseEntity<Collection<CompanyDto>> findAll(){
        Collection<CompanyDto> companies = companyService.findAll();
        LOGGER_INFO.info("Action: GC");
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Company> getByEmail(@PathVariable String email){
        Company company = companyService.getByEmail(email);
        LOGGER_INFO.info("Action: GC/:email");
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping("/owner")
    public ResponseEntity<Company> getByOwner(Principal principal){
        Company company = companyService.getByEmail(principal.getName());
        LOGGER_INFO.info("User: " + principal.getName() + " | Action: GC/:owner");
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Company company){
        try {
            companyService.update(company);
            LOGGER_INFO.info("User: " + company.getEmail() + " | Action: UC");
            return new ResponseEntity<>("Successfully updated. ", HttpStatus.OK);
        } catch (UnsupportedOperationException e) {
            LOGGER_ERROR.error("User: " + company.getEmail() + " | Action: UC");
            return new ResponseEntity<>("Company does not exist. ", HttpStatus.BAD_REQUEST);
        }
    }
}
