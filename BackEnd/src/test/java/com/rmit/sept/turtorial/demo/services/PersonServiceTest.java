package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.exception.PersonException;
import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PersonServiceTest {
    @Autowired
    private PersonService personService;



    // Test below asserts that the method tested will throw a PersonException due to the given person having either already existed
    // within the repository, or the person already has a person identifier.
    @Test
    public void saveOrUpdatePerson_ThrowsException_IfPersonAlreadyHasIdentifier() {
        Person person = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");

        assertThrows(PersonException.class,
                ()->personService.saveOrUpdatePerson(person),
                "saveOrUpdatePerson method threw a PersonException");
    }
    @Test
    public void findByUsername_isTrue_IfPersonAlreadyHasIdentifier() {
        Person person = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");
        person.setPersonIdentifier("helloworld");
        personService.save(person);

        Person newPerson = personService.findByPersonIdentifier("helloworld");

        assertThat(newPerson.getUsername()).isEqualTo(person.getUsername());
    }
}
