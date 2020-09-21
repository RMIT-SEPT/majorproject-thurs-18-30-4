package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserDetailsImplTest {
    @MockBean
    private UserDetailsImpl userDetails;



    // the test below asserts that the user details built from the user parameter contains equal class variables
    @Test
    public void build_NoErrors_IfBuildMethodCopiesPersonVariablesCorrectly() {
        Person person = new Person();
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
