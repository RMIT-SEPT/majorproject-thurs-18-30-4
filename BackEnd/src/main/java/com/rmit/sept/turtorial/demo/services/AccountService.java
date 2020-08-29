package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.Repositories.AccountRepository;
import com.rmit.sept.turtorial.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account saveOrUpdateAccount(Account account) {
        // logic
        return accountRepository.save(account);
    }
}
