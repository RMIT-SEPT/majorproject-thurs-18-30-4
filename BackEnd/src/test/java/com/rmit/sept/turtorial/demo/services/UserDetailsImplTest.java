package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDetailsImplTest {
    private UserDetailsImpl userDetails = new UserDetailsImpl(new Long(1), "test", "test@email.com",
                        "test", new ArrayList<GrantedAuthority>());
    private Person person = new Person();


    // the test below asserts that the user details built from the user parameter contains equal class variables
    @Test
    public void userDetailsImplBuiltFromUserParamaterShouldHaveEqualClassVariables() {
        person.setId(new Long(100));
        person.setUsername("TestUsername");
        person.setEmail("Test@email.com");
        person.setPassword("TestPassword");

        UserDetailsImpl testUserBuild = userDetails.build(person);

        assertEquals(person.getId(), testUserBuild.getId());
        assertEquals(person.getUsername(), testUserBuild.getUsername());
        assertEquals(person.getEmail(), testUserBuild.getEmail());
        assertEquals(person.getPassword(), testUserBuild.getPassword());

    }
}
