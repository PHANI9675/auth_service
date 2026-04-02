package com.cognizant.auth_service.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/profile")
    public String getProfile(){
        return "Patient Profile";
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/reports")
    public String getReports(){
        return "Patient Reports";
    }


}
