package com.rmit.sept.turtorial.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
// prompt message for person exception
public class PersonException extends RuntimeException {
    public PersonException(String message) {
        super(message);
    }
}
