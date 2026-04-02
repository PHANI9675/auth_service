package com.cognizant.auth_service.controller;

import com.cognizant.auth_service.dto.AuthRequest;
import com.cognizant.auth_service.entity.Role;
import com.cognizant.auth_service.entity.Users;
//import org.apache.catalina.User;
import com.cognizant.auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-lab-tech")
    public String createLabTech(@RequestBody AuthRequest request){
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.LAB_TECH);
        userRepository.save(user);

        return "Lab Technician Created";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
}
