package com.rmit.sept.turtorial.demo.rest.response;

public class MessageResponse {
    private String message;
    //used to show the message of a response
    public MessageResponse(String message) {
        this.message = message;
    }
    //getter for message
    public String getMessage() {
        return message;
    }
    //setter for message
    public void setMessage(String message) {
        this.message = message;
    }
}
