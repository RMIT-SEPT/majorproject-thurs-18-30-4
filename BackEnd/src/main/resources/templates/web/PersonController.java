package com.rmit.sept.turtorial.demo.web;

import com.rmit.sept.turtorial.demo.model.Person;
import com.rmit.sept.turtorial.demo.services.MapValidationErrorService;
import com.rmit.sept.turtorial.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> feature/sophia's-feature

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonController {

    @Autowired
    private PersonService personService;

<<<<<<< HEAD
    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewPerson(@Valid @RequestBody Person person, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        Person project1 = personService.saveOrUpdatePerson(person);
        return new ResponseEntity<Person>(project1, HttpStatus.CREATED);
    }


    @GetMapping("/{personId}")
    public ResponseEntity<?> getPersonById(@PathVariable String personId){

        Person person = personService.findByPersonIdentifier(personId);

        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Person> getAllPersons(){

        return personService.findAllPersons();
    }


    @DeleteMapping("/{personId}")
    public ResponseEntity<?> deleteProject(@PathVariable String personId){
        personService.deletePersonByIdentifier(personId);

        return new ResponseEntity<String>("Person with ID: '"+personId+"' was deleted", HttpStatus.OK);
    }
}
=======

    @PostMapping("")
    public ResponseEntity<?> createNewPerson(@Valid @RequestBody Person person, BindingResult result) {

        if (result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }
        Person person1 = personService.saveOrUpdatePerson(person);
        return new ResponseEntity<Person>(person, HttpStatus.CREATED);
    }
}

>>>>>>> feature/sophia's-feature
