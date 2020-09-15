package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.exception.PersonException;
import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PersonServiceTest {
    @Autowired
    private PersonService personService;

    private Person person;


    // Test below asserts that the method tested will throw a PersonException due to the given person having either already existed
    // within the repository, or the person already has a person identifier.
    @Test
    public void saveOrUpdatePerson_ThrowsException_IfPersonAlreadyHasIdentifier() {
        person.setPersonIdentifier("testIdentifier");
        assertThrows(PersonException.class,
                ()->personService.saveOrUpdatePerson(person),
                "");
    }

    @Test
    public void save_ThrowsException_IfPersonRepositoryIsNull() {
        assertThrows(PersonException.class,
                ()->personService.save(person));
    }

    @Test
    public void test2() {

    }
}
