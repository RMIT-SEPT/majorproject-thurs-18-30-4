package com.rmit.sept.turtorial.demo.validator;

import com.rmit.sept.turtorial.demo.model.Person;
import com.rmit.sept.turtorial.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    //variable for person service
    @Autowired
    private PersonService personService;

    @Override
    //clazz – the Class that this Validator is being asked if it can validate
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    //validation method
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        //validate the length
        if (person.getUsername().length() < 6 || person.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        //validate the username
        if (personService.findByUsername(person.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        //validate the blank and whitespaces
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (person.getPassword().length() < 8 || person.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
/*
        if (!person.getPasswordConfirm().equals(person.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }

 */
    }
}
