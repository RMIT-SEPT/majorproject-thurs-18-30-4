package com.rmit.sept.turtorial.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


@Entity //Specifies that the class is an entity.

//set table name and unique constraints
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id"),
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
  //need to configure mysql
public class Person {

    @Id // generate primary key for id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //declare name variable
    @NotBlank(message = "Person name is required")
    private String name;


    // @Size(min=4,max =5, message = "please enter 4 to 5 characters")
    private String personIdentifier;


    //declare username
    @NotBlank(message = "username is required")
    private String username;

    //declare email
    @NotBlank
    @Email
    private String email;
    //declare password
    @NotBlank(message = "password is required")
    private String password;

    //declare confirm password
    @Transient //does not create a column
    private String passwordConfirm;

    //create a table with both user and role id
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    //create a set of roles
    private Set<Role> roles = new HashSet<>();

    // @NotBlank(message = "desc is required")
    //private String desc;

    //empty constructor for person
    public Person() {
    }
    //constructor with fields for person
    public Person(Long id, String username, String email, String password, String name) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        //this.desc = desc;
        //this.passwordConfirm = passwordConfirm;
    }

    /**
     * Lists of getters and setters
     */
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
/*
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
*/
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
