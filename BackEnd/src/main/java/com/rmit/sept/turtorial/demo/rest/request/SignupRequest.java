package com.rmit.sept.turtorial.demo.rest.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
//used for entering and sending request to signup
public class SignupRequest {
    //required to fill in username field
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    //required to fill in email field
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    //for signing up the user's role
    private Set<String> role;

    //password field
    @NotBlank
    //@Size(min = 6, max = 40)
    private String password;

    //description field
    private String desc;

    //name field
    private String name;

    //confirm password field
    private String passwordConfirm;

    //getter for description
    public String getDesc() { return desc; }

    //getter for name
    public String getName() { return name; }

    //getter for confirm password
    public String getPasswordConfirm() { return passwordConfirm; }

    //getter for username
    public String getUsername() {
        return username;
    }

    //setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    //getter for email
    public String getEmail() {
        return email;
    }

    //setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    //getter for password
    public String getPassword() {
        return password;
    }

    //setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    //getter for role
    public Set<String> getRole() {
        return this.role;
    }

    //setter for role
    public void setRole(Set<String> role) {
        this.role = role;
    }
}
