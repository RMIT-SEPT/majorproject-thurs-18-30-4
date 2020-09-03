package com.rmit.sept.turtorial.demo.services;


import com.rmit.sept.turtorial.demo.model.Role;
import com.rmit.sept.turtorial.demo.repositories.PersonRepository;
import com.rmit.sept.turtorial.demo.exception.PersonException;
import com.rmit.sept.turtorial.demo.model.Person;
import com.rmit.sept.turtorial.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Person saveOrUpdatePerson(Person person) {

        try{
            person.setPersonIdentifier(person.getPersonIdentifier().toUpperCase());
            return personRepository.save(person);
        }catch (Exception e){
            throw new PersonException("Person ID '"+person.getPersonIdentifier().toUpperCase()+"' already exists");
        }

    }


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


    public void deletePersonByIdentifier(String personId){
        Person person = personRepository.findByPersonIdentifier(personId.toUpperCase());

        if(person == null){
            throw  new  PersonException("Cannot Person with ID '"+personId+"'. This person does not exist");
        }

        personRepository.delete(person);
    }

    public void save(Person person) {
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        person.setRoles(new HashSet<>(roleRepository.findAll()));
        personRepository.save(person);
    }

    public Person findByUsername(String username) {
        return personRepository.findByUsername(username);
    }
}
