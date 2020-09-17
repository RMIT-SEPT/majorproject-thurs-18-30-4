package com.rmit.sept.turtorial.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Business {
    @Id
    private Long id;
    @NotBlank(message = "Business name is required")
    private String name;
    @NotBlank(message = "Desc is required")
    private String desc;

    @OneToMany
    private Set<Person> workers = new HashSet<>();

    public Business() {

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Person> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Person> workers) {
        this.workers = workers;
    }
}
