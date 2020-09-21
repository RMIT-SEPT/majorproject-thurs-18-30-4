package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.DemoApplication;
import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserDetailsServiceImplTest {
    @MockBean
    private UserDetailsServiceImpl userDetailsService;

    // the test below asserts that a UsernameNotFoundException should be thrown if the username is not found in the repository
    // currently fails due to personRepository in userDetailsServiceImpl class not being instantiated in the UserDetailsServiceImpl class
    @Test
    public void loadByUsername_personUsernameIsEqual_IfUsernameIsNotFoundInRepository() {
        Person testPerson = new Person();
        testPerson.setUsername("test");

        UserDetails test = userDetailsService.loadUserByUsername(testPerson.getUsername());

        System.out.println(test.getUsername() + " " + testPerson.getUsername());

        assertThat(test.getUsername()).isEqualTo(testPerson.getUsername());

    }

    @Test
    void loadUserByUsername() {
        userDetailsService  = new UserDetailsServiceImpl();
        Person person1 = new Person((long) 123, "user1", "user1@gmail.com", "abc", "User 1");
        assertEquals(person1.getUsername(), userDetailsService.loadUserByUsername("user1").getUsername());
    }
}
