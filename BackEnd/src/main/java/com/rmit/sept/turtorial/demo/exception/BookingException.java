package com.rmit.sept.turtorial.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// General exception class regarding bookings. Will be deleted later with more specific exceptions replacing it.
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookingException extends RuntimeException {

    public BookingException(String message) {
        super(message);
    }
}
