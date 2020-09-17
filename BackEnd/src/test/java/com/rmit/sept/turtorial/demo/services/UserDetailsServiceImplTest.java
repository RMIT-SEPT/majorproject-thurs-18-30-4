package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDetailsServiceImplTest {
    private static UserDetailsServiceImpl userService;

    @BeforeAll
    public static void setUp() {
        userService = new UserDetailsServiceImpl();
    }

    @Test
    void loadUserByUsername(){
        Person person1 = new Person((long) 123,"user1","user1@gmail.com", "abc", "User 1");
        assertEquals(person1.getUsername(), userService.loadUserByUsername("user1").getUsername());
    }

}