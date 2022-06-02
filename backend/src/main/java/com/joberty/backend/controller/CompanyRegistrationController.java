package com.joberty.backend.controller;

import com.joberty.backend.model.CompanyRegistrationRequest;
import com.joberty.backend.service.interfaces.CompanyRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company-registration", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CompanyRegistrationController {

    private final CompanyRegistrationService companyRegistrationService;

    @GetMapping
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CompanyRegistrationRequest>> getAllRegistrationRequests() {
        List<CompanyRegistrationRequest> registrationRequests = companyRegistrationService.getAllRegistrationRequests();
        return new ResponseEntity<>(registrationRequests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> registerCompany (@RequestBody CompanyRegistrationRequest request) {
        CompanyRegistrationRequest createdRequest = companyRegistrationService.saveRegistrationRequest(request);
        return new ResponseEntity<>("Registration request successfully sent to administrator", HttpStatus.CREATED);
    }

    @GetMapping("/approve/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approveRegistrationRequest(@PathVariable("id") Integer requestId) {
        companyRegistrationService.approveRegistrationRequest(requestId);
        return new ResponseEntity<>("Registration request approved!", HttpStatus.CREATED);
    }

    @GetMapping("/reject/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> rejectRegistrationRequest(@PathVariable("id") Integer requestId) {
        companyRegistrationService.rejectRegistrationRequest(requestId);
        return new ResponseEntity<>("Registration request rejected!", HttpStatus.OK);
    }
}
