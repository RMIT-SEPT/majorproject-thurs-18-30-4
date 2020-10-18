package com.rmit.sept.turtorial.test.jwt;

import java.io.Serializable;

/**
 * Represnets to structure of response containing the JWT Token.
 */
public class JwtTokenResponse implements Serializable {

    private static final long serialVersionUID = 8317676219297719109L;

    private final String token;

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}