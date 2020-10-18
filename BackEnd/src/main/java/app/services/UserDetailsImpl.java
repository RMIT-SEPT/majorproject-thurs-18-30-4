package app.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import app.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
// class for getting more information regarding the user details
public class UserDetailsImpl implements UserDetails {
    // used during deserialization to verify that the sender and receiver of a serialized object
    private static final long serialVersionUID = 1L;

    //declare variables for id, name, username, email, password and authorities
    private Long id;
    private String name;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    //constructor for user details implementation with id, name, username,password and authorities field
    public UserDetailsImpl(Long id, String name, String username, String email, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    //build user and return the user information
    public static UserDetailsImpl build(Person user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }
    //getter for authorities
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    //getter for id
    public Long getId() {
        return id;
    }

    //getter for name
    public String getName() { return name; }

    //getter for email
    public String getEmail() {
        return email;
    }

    //getter for password
    @Override
    public String getPassword() {
        return password;
    }

    //getter for username
    @Override
    public String getUsername() {
        return username;
    }

    //status for account regarding if it is expired or not
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //status for account regarding if it is locked or not
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //status for the user credentials regarding if it is expired or not
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //boolean to check if it is enabled
    @Override
    public boolean isEnabled() {
        return true;
    }

    //check if the object matches (id)
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

}