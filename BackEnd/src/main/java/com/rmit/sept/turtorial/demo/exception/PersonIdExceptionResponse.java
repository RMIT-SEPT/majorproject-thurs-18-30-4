package com.rmit.sept.turtorial.demo.exception;

public class PersonIdExceptionResponse {
    private String personIdentifier;

    public PersonIdExceptionResponse(String projectIdentifier) {
        this.personIdentifier = projectIdentifier;
    }

    public String getPersonIdentifier() {
        return personIdentifier;
    }

    public void setPersonIdentifier(String personIdentifier) {
        this.personIdentifier = personIdentifier;
    }
}
