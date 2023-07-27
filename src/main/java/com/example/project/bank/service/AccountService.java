package com.example.project.bank.service;

import com.example.project.bank.model.Account;
import com.example.project.bank.persistence.AccountRepository;

import java.util.Optional;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 26.07.23.
 */
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void transferMoney(String fromAccountIban, String toAccountIban, int amount) {
        var fromAccount = repository.findAccount(fromAccountIban).orElseThrow();
        var toAccount = repository.findAccount(toAccountIban).orElseThrow();
        fromAccount.withDrawMoney(amount);
        toAccount.addMoney(amount);
    }
}
