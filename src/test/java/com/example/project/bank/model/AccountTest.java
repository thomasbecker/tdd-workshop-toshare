package com.example.project.bank.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 25.07.23.
 */
class AccountTest {
    @Test
    void accountCreationWithValidInputWorks() {
        var accountHolderName = "John Doe";
        var iban = "DE2450050010500100123";

        var account = new Account(accountHolderName, iban);

        assertThat(account.getAccountHolder()).isEqualTo(accountHolderName);
        assertThat(account.getIban()).isEqualTo(iban);
    }

    @Test
    void accountCreationThrowsExceptionWhenThereIsNoValidAccountNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Account("John Doe", ""))
                .withMessage("Iban must not be blank or null.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Account("John Doe", null))
                .withMessage("Iban must not be blank or null.");
    }

    @Test
    void accountCreationThrowsExceptionWhenThereIsNoValidAccountHolder() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Account("", "DE24500100105005005001"))
                .withMessage("AccountHolder must not be blank or null.");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Account(null, "DE24500100105005005001"))
                .withMessage("AccountHolder must not be blank or null.");
    }

    @Test
    void newAccountsHaveABalanceOfZero() {
        var account = new Account("John Doe", "DE2450050010500100123");
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    void accountReturnsItsCorrectBalance() {
        var account = new Account("John Doe", "DE2450050010500100123", 10);
        assertThat(account.getBalance()).isEqualTo(10);
    }

    @Test
    void addMoneyToAccountWorksFine() {
        var account = new Account("John Doe", "DE234234234324");
        var balanceBeforeTransaction = 0;
        assertThat(account.getBalance()).isEqualTo(balanceBeforeTransaction);
        var amountToAdd = 1000;
        account.addMoney(amountToAdd);
        var expectedBalanceAfterTransaction = balanceBeforeTransaction + amountToAdd;
        assertThat(account.getBalance()).isEqualTo(expectedBalanceAfterTransaction);
    }

    @Test
    void withDrawMoneyFromAccountWorksFine() {
        var account = new Account("John Doe", "DE234234234324");
        var balanceBeforeTransaction = 0;
        assertThat(account.getBalance()).isEqualTo(balanceBeforeTransaction);
        var amountToRemove = 500;
        var balanceAfterTransaction = balanceBeforeTransaction - amountToRemove;

        account.withDrawMoney(amountToRemove);

        assertThat(account.getBalance()).isEqualTo(balanceAfterTransaction);
    }

    //    @Test
//    void throwsExceptionWhenIbanLengthIsNotCorrespondingToCountrysIbanLength() {
//        assertThatExceptionOfType(IllegalArgumentException.class)
//                .isThrownBy(() -> {
//                    new Account("John Doe", "DE50050010123123123");
//                })
//                .withMessage("Iban length doesn't match country's iban length.");
//    }

}
