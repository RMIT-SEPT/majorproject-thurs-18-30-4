package com.rmit.sept.turtorial.demo.rest.request;

import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginRequestTest {
    private static LoginRequest loginRequest;
    Person person1 = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");

    @BeforeAll
    public static void setUp() {
        loginRequest = new LoginRequest();
    }

    @Test
    void getUsername() {
        loginRequest.setUsername("user1");
        Person person1 = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");
        assertEquals(loginRequest.getUsername(), person1.getUsername());
    }

    @Test
    void setUsername() {
        Person person1 = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");
        person1.setUsername("a");
        assertEquals("a",person1.getUsername());
    }

    @Test
    void getPassword() {
        loginRequest.setPassword("abc");
        Person person1 = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");
        assertEquals(loginRequest.getPassword(), person1.getPassword());
    }

    @Test
    void setPassword() {
        Person person1 = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");
        person1.setPassword("cba");
        assertEquals("cba",person1.getPassword());
    }
}