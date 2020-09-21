package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTests {
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
