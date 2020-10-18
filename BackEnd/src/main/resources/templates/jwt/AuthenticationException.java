package com.rmit.sept.turtorial.test.jwt;

/**
 * Use to throw invalid credentials or token exception
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}