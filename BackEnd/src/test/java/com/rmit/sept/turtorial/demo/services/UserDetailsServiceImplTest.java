package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.DemoApplication;
import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserDetailsServiceImplTest {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // the test below asserts that a UsernameNotFoundException should be thrown if the username is not found in the repository
    // currently fails due to personRepository in userDetailsServiceImpl class not being instantiated in the UserDetailsServiceImpl class
    @Test
    public void loadByUsername_ThrowsException_IfUsernameIsNotFoundInRepository() {
        Person testPerson = new Person();
        testPerson.setUsername("test");
        assertThrows(UsernameNotFoundException.class,
                ()->userDetailsService.loadUserByUsername(testPerson.getUsername()));
    }
}
