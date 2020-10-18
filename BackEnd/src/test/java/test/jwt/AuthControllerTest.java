package com.rmit.sept.turtorial.demo.jwt;

import com.rmit.sept.turtorial.demo.model.Person;
import com.rmit.sept.turtorial.demo.model.Role;
import com.rmit.sept.turtorial.demo.repositories.PersonRepository;
import com.rmit.sept.turtorial.demo.repositories.RoleRepository;
import com.rmit.sept.turtorial.demo.rest.request.LoginRequest;
import com.rmit.sept.turtorial.demo.rest.request.SignupRequest;
import com.rmit.sept.turtorial.demo.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AuthControllerTest {

    @Autowired
    private AuthController authController;

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private PersonService personService;

    // This tests to see if a default signup request will return a responseEntity of HttpStatus.OK from the
    // registerUser method
    // It currently fails due to some problem with the role repository
    @Test
    public void registerUserTest_positive() {
        SignupRequest signupRequest = new SignupRequest();

        signupRequest.setEmail("test@test.com");
        signupRequest.setPassword("test_password");
        Set<String> role = new HashSet<String>();
        signupRequest.setRole(role);
        signupRequest.setUsername("test_username");
        signupRequest.setName("Test Test");


        ResponseEntity<?> responseEntity = authController.registerUser(signupRequest);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    // This tests to see if the responseEntity is of HttpStatus.BAD_REQUEST when registering details of an already
    // existing user
    // Currently failing due to a constraint violation in the database, where the violation was a duplicate entry
    @Test
    public void registerUserTest_usernameAlreadyUsed() {
        Person person = new Person();
        person.setName("tester");
        person.setUsername("tester");
        person.setPassword("tester");
        person.setEmail("tester@tester.com");

        personService.save(person);

        SignupRequest signupRequest = new SignupRequest();

        signupRequest.setEmail("test@test.com");
        signupRequest.setPassword("test");
        Set<String> role = new HashSet<String>();
        signupRequest.setRole(role);
        signupRequest.setUsername("tester");
        signupRequest.setName("Test");

        ResponseEntity<?> responseEntity = authController.registerUser(signupRequest);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void registerUserTest_emailAlreadyUsed() {
        Person person = new Person();
        person.setName("tester");
        person.setUsername("tester");
        person.setPassword("tester");
        person.setEmail("tester@tester.com");

        personService.save(person);

        SignupRequest signupRequest = new SignupRequest();

        signupRequest.setEmail("tester@tester.com");
        signupRequest.setPassword("test");
        Set<String> role = new HashSet<String>();
        signupRequest.setRole(role);
        signupRequest.setUsername("test");
        signupRequest.setName("Test");

        ResponseEntity<?> responseEntity = authController.registerUser(signupRequest);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void authenticateUser_fail() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("test");
        loginRequest.setPassword("test");

        assertThrows(BadCredentialsException.class,
                ()->{authController.authenticateUser(loginRequest);},
                "BadCredentialsException has been thrown as username does not exist");
    }

    @Test
    public void authenticateUser_pass() {
        Person person = new Person();
        person.setUsername("test");
        person.setPassword("test");
        person.setEmail("test@tester.com");
        person.setName("Test Tester");
        personService.save(person);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("test");
        loginRequest.setPassword("test");

        assertThat(authController.authenticateUser(loginRequest).getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
