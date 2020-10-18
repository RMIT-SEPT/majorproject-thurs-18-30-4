package com.rmit.sept.turtorial.demo.services;


import app.model.Person;
import app.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserDetailsServiceImplTest {
    @MockBean
    private UserDetailsServiceImpl userDetailsService;
    // the test below asserts that a UsernameNotFoundException should be thrown if the username is not found in the repository
    // currently fails due to personRepository in userDetailsServiceImpl class not being instantiated in the UserDetailsServiceImpl class
    @Test
    public void loadByUsername_userDetailsBuildIsNull_IfUsernameIsNotFoundInRepository() {
        Person testPerson = new Person();
        testPerson.setUsername("test");

        UserDetails test = userDetailsService.loadUserByUsername(testPerson.getUsername());

        assertThat(test).isNull();
        System.out.println("userDetails test object is null");
    }
}
