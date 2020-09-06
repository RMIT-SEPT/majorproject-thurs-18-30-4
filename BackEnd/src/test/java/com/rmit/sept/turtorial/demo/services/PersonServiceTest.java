package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.exception.PersonException;
import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {

    private PersonService personService = new PersonService();
    private Person person = new Person();


    // Test below asserts that the method tested will throw a PersonException due to the given person having either already existed
    // within the repository, or the person already has a person identifier.
    @Test
    public void shouldThrowPersonException() {
        person.setPersonIdentifier("testIdentifier");
        assertThrows(PersonException.class,
                ()->personService.saveOrUpdatePerson(person),
                "");
    }
}
