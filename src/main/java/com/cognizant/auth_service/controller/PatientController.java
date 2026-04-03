package com.cognizant.auth_service.controller;

import com.cognizant.auth_service.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private AuditLogService auditLogService;

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/profile")
    public String getProfile(){
        return "Patient Profile";
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/reports")
    public String getReports(Authentication auth){
        auditLogService.log(auth.getName(),
                "PATIENT",
                "VIEWED_REPORTS",
                "/patient/profile");
        return "Patient Reports";
    }


}
