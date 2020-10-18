package app.validator;

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
        return "Customer Dashboard | ALL ACCESS";
    }
    //set permission for worker
    //access to worker and admin
    @GetMapping("/worker")
    @PreAuthorize("hasRole('WORKER') or hasRole('ADMIN')")
    public String workerAccess() {
        return "Worker Dashboard | WORKER & ADMIN ACCESS";
    }
    //set permission for admin
    //access to admin
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Dashboard | ADMIN ACCESS";
    }
}
