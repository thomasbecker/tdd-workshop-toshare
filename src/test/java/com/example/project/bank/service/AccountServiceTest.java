package com.example.project.bank.service;

import com.example.project.bank.model.Account;
import com.example.project.bank.persistence.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 26.07.23.
 */
@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock
    private AccountRepository repository;
    AccountService accountService;
    @BeforeEach
    void setUp() {
        accountService  = new AccountService(repository);
    }

    @Test
    void transferMoneyFromOneAccountToAnotherWorks() {
        var fromAccountIban = "DE234234";
        var fromAccount = new Account("John Doe", fromAccountIban);
        var toAccountIban = "DE234235";
        var toAccount = new Account("Jane Doe", toAccountIban);
        var fromAccountBalanceBeforeTransaction = 1000;
        var toAccountBalanceBeforeTransaction = toAccount.getBalance();
        fromAccount.addMoney(fromAccountBalanceBeforeTransaction);
        var amountToTransfer = 500;
        var fromAccountBalanceAfterTransaction = fromAccountBalanceBeforeTransaction - amountToTransfer;
        var toAccountBalanceAfterTransaction = toAccountBalanceBeforeTransaction + amountToTransfer;
        when(repository.findAccount(fromAccountIban)).thenReturn(Optional.of(fromAccount));
        when(repository.findAccount(toAccountIban)).thenReturn(Optional.of(toAccount));

        accountService.transferMoney(fromAccountIban, toAccountIban, amountToTransfer);

        assertThat(fromAccount.getBalance()).isEqualTo(fromAccountBalanceAfterTransaction);
        assertThat(toAccount.getBalance()).isEqualTo(toAccountBalanceAfterTransaction);
    }
}
