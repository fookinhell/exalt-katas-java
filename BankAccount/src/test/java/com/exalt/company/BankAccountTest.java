package com.exalt.company;

import com.exalt.company.domain.BankAccount;
import com.exalt.company.port.IAccountGetter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountTest {

    private IAccountGetter hardCodedData;

    @BeforeEach
    public void initData() {
        hardCodedData = new IAccountGetter() {
            @Override
            public BankAccount load() {
                BankAccount bankAccount = new BankAccount(1, 500);
                bankAccount.deposit(150);
                bankAccount.deposit(300);
                bankAccount.withdraw(200);
                return bankAccount; // balance = 750
            }

            @Override
            public void save(BankAccount bankAccount) {

            }
        };
    }

    @AfterEach
    public void undefData() {
        hardCodedData = null;
    }

    @ParameterizedTest
    @CsvSource({
            "150, 900"
    })
    void depositWithData_balanceMustIncrease(double amountToDeposit, double expectedBalance) {
        BankAccount account = new BankAccount(hardCodedData);

        account.deposit(amountToDeposit);

        System.out.println(account.getHistory());
        assertEquals(expectedBalance, account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "150, 600"
    })
    void withdrawWithData_balanceMustDecrease(double amountToWithdraw, double expectedBalance) {
        BankAccount account = new BankAccount(hardCodedData);

        account.withdraw(amountToWithdraw);

        System.out.println(account.getHistory());
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void historyWithData_showFullHistoryOfOperations() {
        BankAccount account = new BankAccount(hardCodedData);

        account.deposit(200);
        account.withdraw(125);

        System.out.println(account.getHistory());
        assertTrue(account.getHistory().contains("DEPOSIT, amount : +200.0")
                && account.getHistory().contains("WITHDRAWAL, amount : -125.0"));
    }

    @ParameterizedTest
    @CsvSource({
            "125, 125, 250"
    })
    void deposit_balanceMustIncrease(double initBalance, double amountToDeposit, double expectedBalance) {
        BankAccount account = new BankAccount(1, initBalance);

        account.deposit(amountToDeposit);

        System.out.println(account.getHistory());
        assertEquals(expectedBalance, account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "125, 125, 0"
    })
    void withdraw_balanceMustDecrease(double initBalance, double amountToWithdraw, double expectedBalance) {
        BankAccount account = new BankAccount(1, initBalance);

        account.withdraw(amountToWithdraw);

        System.out.println(account.getHistory());
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void history_showFullHistoryOfOperations() {
        BankAccount account = new BankAccount(1, 125);

        account.deposit(200);
        account.withdraw(125);

        System.out.println(account.getHistory());
        assertTrue(account.getHistory().contains("DEPOSIT") && account.getHistory().contains("WITHDRAW"));
    }


}
