package com.exalt.company.port;

import com.exalt.company.domain.BankAccount;

public interface IBankOperator {

    void deposit(int id, double amount);

    void withdraw(int id, double amount);

    double getBalance(int id);

    String getHistory(int id);

    BankAccount getAccount(int id);
}
