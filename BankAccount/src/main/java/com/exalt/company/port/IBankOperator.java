package com.exalt.company.port;

public interface IBankOperator {

    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();

    String getHistory();
}
