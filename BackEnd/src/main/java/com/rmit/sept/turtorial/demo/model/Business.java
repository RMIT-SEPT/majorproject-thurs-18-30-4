package com.rmit.sept.turtorial.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "business",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
public class Business {
    @Id
    private Long id;
    @NotBlank(message = "Business name is required")
    private String name;
    @NotBlank(message = "Desc is required")
    private String description;

    @OneToMany
    @JoinTable(	name = "business_workers",
            joinColumns = @JoinColumn(name = "business_id"),
            inverseJoinColumns = @JoinColumn(name = "worker_id")
    )
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
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public Set<Person> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Person> workers) {
        this.workers = workers;
    }
}
