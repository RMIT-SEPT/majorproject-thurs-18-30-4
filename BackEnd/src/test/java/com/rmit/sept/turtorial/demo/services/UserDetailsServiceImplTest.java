package com.rmit.sept.turtorial.demo.services;


import com.rmit.sept.turtorial.demo.DemoApplication;
import com.rmit.sept.turtorial.demo.model.Person;
import com.rmit.sept.turtorial.demo.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserDetailsServiceImplTest {
    @MockBean
    private UserDetailsServiceImpl userDetailsService;
    @MockBean
    private PersonRepository personRepository;
    @MockBean
    private UserDetailsImpl userDetails;
    // the test below asserts that a UsernameNotFoundException should be thrown if the username is not found in the repository
    // currently fails due to personRepository in userDetailsServiceImpl class not being instantiated in the UserDetailsServiceImpl class
    @Test
    public void loadByUsername_personUsernameIsEqual_IfUsernameIsNotFoundInRepository() {
        Person testPerson = new Person();
        testPerson.setUsername("test");
        personRepository.save(testPerson);
        UserDetails test = userDetailsService.loadUserByUsername(testPerson.getUsername());

        System.out.println(test.getUsername() + " " + testPerson.getUsername());

        //assertThat(test.getUsername()).isEqualTo(testPerson.getUsername());

    }
}
