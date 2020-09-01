package com.rmit.sept.turtorial.demo.repositories;

import com.rmit.sept.turtorial.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByPersonIdentifier(String personID);

    @Override
    Iterable<Person> findAll();

    Person findByUsername(String username);
}