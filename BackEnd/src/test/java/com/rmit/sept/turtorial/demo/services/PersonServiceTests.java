package com.rmit.sept.turtorial.demo.services;

import app.model.Person;
import app.services.PersonService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTests {
    @MockBean
    private static PersonService ps;

    Person person1 = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");

    @BeforeAll
    public static void setup() {
        ps = new PersonService();
    }
    @BeforeEach
    public void init() {
        ps.save(person1);
    }
    @Test
    public void testFindByUsername() {
        Person person1 = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");
        assertEquals(person1.getUsername(), ps.findByUsername("user1"));
    }


}
