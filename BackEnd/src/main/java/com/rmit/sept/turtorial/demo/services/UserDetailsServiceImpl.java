package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.model.Person;
import com.rmit.sept.turtorial.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/*
        // instantiating a person object from username parameter
        Person person = personRepository.findByUsername(username);
        // if the person is null, throw an exception
        if (person == null) {
            throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        // for each role that the person has, grant authority based on the roles
        for (Role role : person.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority((role.getNameAsString())));
        }

        // return the person with username, password and authorities
        return new org.springframework.security.core.userdetails.User(person.getUsername(), person.getPassword(), grantedAuthorities);

 */
        Person user = personRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
