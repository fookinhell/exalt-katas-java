package com.exalt.company.domain;


import com.exalt.company.domain.record.Deposit;
import com.exalt.company.domain.record.IRegistryRecord;
import com.exalt.company.domain.record.RegistryRecord;
import com.exalt.company.domain.record.Withdrawal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private double balance;

    private final List<IRegistryRecord> registry;

    public BankAccount(double initBalance) {
        this.balance = initBalance;
        this.registry = new ArrayList<>();
    }

    public void deposit(double amount) {
        executeRecord(new Deposit(balance, amount, LocalDateTime.now()));
    }

    public void withdraw(double amount) {
        executeRecord(new Withdrawal(balance, amount, LocalDateTime.now()));
    }

    public void executeRecord(RegistryRecord record) {
        balance = record.execute();
        registry.add(record);
    }

    public double getBalance() {
        return balance;
    }

    public String getHistory() {
        StringBuilder history = new StringBuilder();
        for (IRegistryRecord record : registry) {
            history.append(record.getStatement()).append(System.getProperty("line.separator"));
        }
        return history.toString();
    }
}
