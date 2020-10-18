package app.repositories;

import app.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    //variable to find by person ID
    Person findByPersonIdentifier(String personID);

    @Override
    //variable to find all persons
    Iterable<Person> findAll();
    //variable to find by username of a person
    Optional<Person> findByUsername(String username);

    //check if username exists
    Boolean existsByUsername(String username);
    //check if email exists
    Boolean existsByEmail(String email);
}
