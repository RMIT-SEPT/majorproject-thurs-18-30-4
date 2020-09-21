package com.rmit.sept.turtorial.demo.rest.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer"; // Bearer Authentication type
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    //constructor for JWT with fields such as access token, id, username, email and role
    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
    //getter for access token
    public String getAccessToken() {
        return token;
    }

    //setter for access token
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    //getter for token type
    public String getTokenType() {
        return type;
    }

    //setter for token type
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    //getter for id
    public Long getId() {
        return id;
    }

    //setter for id
    public void setId(Long id) {
        this.id = id;
    }

    //getter for email
    public String getEmail() {
        return email;
    }

    //setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    //getter for username
    public String getUsername() {
        return username;
    }

    //setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    //getter for role
    public List<String> getRoles() {
        return roles;
    }
}
