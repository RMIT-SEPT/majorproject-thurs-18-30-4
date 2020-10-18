package app.jwt;

import app.model.Person;
import app.model.Role;
import app.repositories.PersonRepository;
import app.repositories.RoleRepository;
import app.rest.request.LoginRequest;
import app.rest.request.SignupRequest;
import app.rest.response.JwtResponse;
import app.rest.response.MessageResponse;
import app.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
// controller class to manage the authentication
public class    AuthController {
    //variable for authentication manager
    @Autowired
    AuthenticationManager authenticationManager;
    //variable for user repository
    @Autowired
    PersonRepository userRepository;
    //variable for role repository
    @Autowired
    RoleRepository roleRepository;
    //variable for password encoder
    @Autowired
    PasswordEncoder encoder;
    // variable for jwt utilities
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    //response when committing a login
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        //authenticate the username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        //set the authentication
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //generate JWT token
        String jwt = jwtUtils.generateJwtToken(authentication);

        //user details
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        //return the response when login is successful with jwt token, id, username, email and role
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getName(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    //response when committing a signup
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        //validate if the username is already taken
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        //validate if the email is already taken
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Person user = new Person(100L, signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword())
                , signUpRequest.getName()
        );

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        //validate if the role exists
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(Role.ERole.ROLE_CUSTOMER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(Role.ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "worker":
                        Role modRole = roleRepository.findByName(Role.ERole.ROLE_WORKER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(Role.ERole.ROLE_CUSTOMER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        //set the role to the user
        user.setRoles(roles);

        //save the user in the user repository
        userRepository.save(user);

        //message indicating it is successful
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}