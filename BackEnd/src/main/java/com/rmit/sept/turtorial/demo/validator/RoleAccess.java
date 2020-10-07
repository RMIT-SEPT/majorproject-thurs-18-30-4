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
    //set permission to all
    @GetMapping("/all")
    public String publicAccess() {
        return "Public Content.";
    }
    //set permission for customer
    //access to customer, worker and admin
    @GetMapping("/customer")
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('WORKER') or hasRole('ADMIN')")
    public String customerAccess() {
        return "Customer Access.";
    }
    //set permission for worker
    //access to worker and admin
    @GetMapping("/worker")
    @PreAuthorize("hasRole('WORKER') or hasRole('ADMIN')")
    public String workerAccess() {
        return "Worker Access.";
    }
    //set permission for admin
    //access to admin
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Access.";
    }
}
