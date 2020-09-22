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

    //person repository variable
    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional //set the transactional attribute
    //load the user by username and prompt error message if user not found
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person user = personRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
