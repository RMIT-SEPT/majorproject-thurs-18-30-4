package com.rmit.sept.turtorial.demo.web;

import com.rmit.sept.turtorial.demo.model.Account;
import com.rmit.sept.turtorial.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<?> createNewAccount(@Valid @RequestBody Account account, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<String>("Invalid Account Object", HttpStatus.BAD_REQUEST);
        }
        Account account1 = accountService.saveOrUpdateAccount(account);
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }
}
