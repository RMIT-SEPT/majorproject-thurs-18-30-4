package app.rest.request;

import javax.validation.constraints.NotBlank;

//used for entering and sending request to login
public class LoginRequest {
    //username variable
    @NotBlank
    private String username;
    //passwoord variable
    @NotBlank
    private String password;
    //getter for username
    public String getUsername() {
        return username;
    }
    //setter for username
    public void setUsername(String username) {
        this.username = username;
    }
    //getter for password
    public String getPassword() {
        return password;
    }
    //setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
