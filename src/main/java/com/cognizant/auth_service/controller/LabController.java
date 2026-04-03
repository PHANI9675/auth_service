package com.cognizant.auth_service.controller;

import com.cognizant.auth_service.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/labTech")
public class LabController {

    @Autowired
    private AuditLogService auditLogService;
    @PreAuthorize("hasRole('LAB_TECH')")
    @PostMapping("/upload")
    public String uploadReport(Authentication auth){
        auditLogService.log(auth.getName(),
                "LAB_TECH",
                "UPLOADED_REPORT",
                "/labTech.upload");
        return "Report Uploaded";
    }

    @PreAuthorize("hasRole('LAB_TECH')")
    @GetMapping("/reports")
    public String getReports(){
        return "Patient Reports";
    }
}
