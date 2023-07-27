package com.example.project.bank.model;

import java.util.Map;
import java.util.Optional;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 25.07.23.
 */
public class Account {
    private final String iban;
    private String accountHolder;
    private int balance = 0;

    private static final Map IBAN_LENGTHS = Map.of("DE", 22);

    /**
     * This constructor is only to be used in testing
     */
    Account(String accountHolder, String iban, int balance) {
        this(accountHolder, iban);
        this.balance = balance;
    }

    public Account(String accountHolder, String iban) {
        if (iban == null || iban.isBlank()) {
            throw new IllegalArgumentException("Iban must not be blank or null.");
        }
        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException("AccountHolder must not be blank or null.");
        }
//        var ibanCountryPrefix = iban.substring(0, 2);
//        if(IBAN_LENGTHS.get(ibanCountryPrefix) == null) {
//            throw new IllegalStateException("Ibans from country: %s not supported.".formatted(ibanCountryPrefix));
//        }
        this.accountHolder = accountHolder;
        this.iban = iban;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getIban() {
        return iban;
    }

    public int getBalance() {
        return balance;
    }

    public void addMoney(int amountToAdd) {
        balance = balance + amountToAdd;
    }

    public void withDrawMoney(int amountToRemove) {
        balance = balance - amountToRemove;
    }
}
