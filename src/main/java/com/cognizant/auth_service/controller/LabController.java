package com.cognizant.auth_service.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/labTech")
public class LabController {

    @PreAuthorize("hasRole('LAB_TECH')")
    @PostMapping("/upload")
    public String uploadReport(){
        return "Report Uploaded";
    }

    @PreAuthorize("hasRole('LAB_TECH')")
    @GetMapping("/reports")
    public String getReports(){
        return "Patient Reports";
    }
}
