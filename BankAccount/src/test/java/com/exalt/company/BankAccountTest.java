package com.exalt.company;

import com.exalt.company.domain.BankAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountTest {


    @ParameterizedTest
    @CsvSource({
            "125, 125, 250"
    })
    void deposit_balanceMustIncrease(double initBalance, double amountToDeposit, double expectedBalance) {
        BankAccount account = new BankAccount(initBalance);

        account.deposit(amountToDeposit);

        System.out.println(account.getHistory());
        assertEquals(expectedBalance, account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "125, 125, 0"
    })
    void withdraw_balanceMustDecrease(double initBalance, double amountToWithdraw, double expectedBalance) {
        BankAccount account = new BankAccount(initBalance);

        account.withdraw(amountToWithdraw);

        System.out.println(account.getHistory());
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void history_showFullHistoryOfOperations() {
        BankAccount account = new BankAccount(125);

        account.deposit(200);
        account.withdraw(125);

        System.out.println(account.getHistory());
        assertTrue(account.getHistory().contains("DEPOSIT") && account.getHistory().contains("WITHDRAW"));
    }

}
