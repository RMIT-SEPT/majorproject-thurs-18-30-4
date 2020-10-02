package com.rmit.sept.turtorial.demo.validator;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3000)
@RestController
@RequestMapping("/api/test")
public class RoleAccess {
    @GetMapping("/all")
    public String publicAccess() {
        return "Public Content.";
    }

    @GetMapping("/customer")
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('WORKER') or hasRole('ADMIN')")
    public String customerAccess() {
        return "Customer Access.";
    }

    @GetMapping("/worker")
    @PreAuthorize("hasRole('WORKER')")
    public String workerAccess() {
        return "Worker Access.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Access.";
    }
}
