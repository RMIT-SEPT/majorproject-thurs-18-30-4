package com.rmit.sept.turtorial.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilege {
    // Represents the authority within a system based on given roles
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Collection<Role> roles;
}
