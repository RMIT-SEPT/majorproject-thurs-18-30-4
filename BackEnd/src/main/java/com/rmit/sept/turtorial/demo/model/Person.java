package com.rmit.sept.turtorial.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
  //need to configure mysql
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Person name is required")
    private String name;

   // @Size(min=4,max =5, message = "please enter 4 to 5 characters")
    private String personIdentifier;

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank(message = "password is required")
    private String password;

    @Transient
    //@NotBlank
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.LAZY)

    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    //need to configure mysql
    private Set<Role> roles = new HashSet<>();


    @NotBlank(message = "desc is required")
    private String description;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date start_date;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date end_date;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date created_At;
    @JsonFormat(pattern ="yyyy-MM-dd")
    private Date updated_At;

    public Person() {
    }

    public Person(Long id, String username, String email, String password, String name) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        //this.desc = desc;
       // this.passwordConfirm = passwordConfirm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonIdentifier() {
        return personIdentifier;
    }

    public void setPersonIdentifier(String personIdentifier) {
        this.personIdentifier = personIdentifier;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public Set<Role> getRoles() { return roles; }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Object getPasswordConfirm() { return passwordConfirm; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
