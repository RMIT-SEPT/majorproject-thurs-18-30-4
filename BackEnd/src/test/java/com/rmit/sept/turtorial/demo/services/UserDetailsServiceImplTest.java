package com.rmit.sept.turtorial.demo.services;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserDetailsServiceImplTest {
    private UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();

    // the test below asserts that a UsernameNotFoundException should be thrown if the username is not found in the repository
    // currently fails and throws a NullPointerException instead - need to fix
    @Test
    public void shouldThrowUsernameNotFoundException() {
        assertThrows(UsernameNotFoundException.class,
                ()->userDetailsService.loadUserByUsername("TestUsername"));
    }
}
