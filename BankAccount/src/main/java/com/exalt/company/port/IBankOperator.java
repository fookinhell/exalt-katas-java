package com.exalt.company.port;

public interface IBankOperator {

    void deposit(int id, double amount);

    void withdraw(int id, double amount);

    double balance(int id);

    String history(int id);
}
