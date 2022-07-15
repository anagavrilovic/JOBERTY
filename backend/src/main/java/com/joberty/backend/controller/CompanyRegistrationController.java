package com.joberty.backend.controller;

import com.joberty.backend.model.CompanyRegistrationRequest;
import com.joberty.backend.service.interfaces.CompanyRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static com.joberty.backend.JobertyApplication.LOGGER_INFO;

@RestController
@RequestMapping(value = "/company-registration", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CompanyRegistrationController {

    private final CompanyRegistrationService companyRegistrationService;

    @GetMapping
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CompanyRegistrationRequest>> getAllRegistrationRequests(Principal principal) {
        List<CompanyRegistrationRequest> registrationRequests = companyRegistrationService.getAllRegistrationRequests();
        LOGGER_INFO.info("User: " + principal.getName() + " | Action: GCRR");
        return new ResponseEntity<>(registrationRequests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> registerCompany(@RequestBody CompanyRegistrationRequest request) {
        CompanyRegistrationRequest createdRequest = companyRegistrationService.saveRegistrationRequest(request);
        LOGGER_INFO.info("User: " + request.getEmail() + " | Action: CRR");
        return new ResponseEntity<>("Registration request successfully sent to administrator", HttpStatus.CREATED);
    }

    @GetMapping("/approve/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approveRegistrationRequest(@PathVariable("id") Integer requestId, Principal principal) {
        companyRegistrationService.approveRegistrationRequest(requestId);
        LOGGER_INFO.info("User: " + principal.getName() + " | Action: ARR");
        return new ResponseEntity<>("Registration request approved!", HttpStatus.CREATED);
    }

    @GetMapping("/reject/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> rejectRegistrationRequest(@PathVariable("id") Integer requestId, Principal principal) {
        companyRegistrationService.rejectRegistrationRequest(requestId);
        LOGGER_INFO.info("User: " + principal.getName() + " | Action: RRR");
        return new ResponseEntity<>("Registration request rejected!", HttpStatus.OK);
    }
}
