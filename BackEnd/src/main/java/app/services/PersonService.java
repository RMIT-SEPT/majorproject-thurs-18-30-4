package app.services;


import app.exception.PersonException;
import app.repositories.PersonRepository;
import app.repositories.RoleRepository;
import app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashSet;
import java.util.Optional;

@CrossOrigin
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // Tries to return a person object via save() method from personRepository, throwing an exception if the person ID exists
    public Person saveOrUpdatePerson(Person person) {

        try{
            person.setPersonIdentifier(person.getPersonIdentifier().toUpperCase());
            return personRepository.save(person);
        }catch (Exception e){
            throw new PersonException("Person ID '"+person.getPersonIdentifier().toUpperCase()+"' already exists");
        }

    }

    // calls the findByPersonIdentifer() method from personRepository using personId, and retuns the instantiated person
    // throws an exception if the instantiated person is null
    public Person findByPersonIdentifier(String personId){

        Person person = personRepository.findByPersonIdentifier(personId.toUpperCase());

        if(person == null){
            throw new PersonException("Person ID '"+personId+"' does not exist");
        }

        return person;
    }

    public Iterable<Person> findAllPersons(){
        return personRepository.findAll();
    }


    // instantiates a person object via findByPersonIdentifier() and deletes the object from repository
    // throws an exception if the person is null
    public void deletePersonByIdentifier(String personId){
        Person person = personRepository.findByPersonIdentifier(personId.toUpperCase());

        if(person == null){
            throw  new  PersonException("Cannot Person with ID '"+personId+"'. This person does not exist");
        }

        personRepository.delete(person);
    }

    // sets the given person with an encoded password and rolls, returning the person object from the save() method
    public void save(Person person) {
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        person.setRoles(new HashSet<>(roleRepository.findAll()));
        personRepository.save(person);
    }

    public Optional<Person> findByUsername(String username) {
        return personRepository.findByUsername(username);
    }
}
