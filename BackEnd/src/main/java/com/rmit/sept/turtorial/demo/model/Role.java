package com.rmit.sept.turtorial.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
//need to configure the database in our IDE
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Use enum roles
    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private ERole name;

    @ManyToMany(mappedBy = "roles")
    private Collection<Person> people;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public String getNameAsString() {
        return name.toString();
    }

    public Collection<Person> getPeople() {
        return people;
    }

    public void setPeople(Collection<Person> people) {
        this.people = people;
    }
}

enum ERole {
    ROLE_CUSTOMER,
    ROLE_WORKER,
    ROLE_ADMIN
}