package com.exalt.company.domain;


import com.exalt.company.domain.record.Deposit;
import com.exalt.company.domain.record.IRegistryRecord;
import com.exalt.company.domain.record.RegistryRecord;
import com.exalt.company.domain.record.Withdrawal;
import com.exalt.company.port.IAccountGetter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Serializable {

    private int id;
    private double balance;

    private final List<IRegistryRecord> registry;

    public BankAccount(int id, double initBalance) {
        this.id = id;
        this.balance = initBalance;
        this.registry = new ArrayList<>();
    }

    public BankAccount(IAccountGetter getter) {
        BankAccount loadedAccount = getter.load();
        this.id = loadedAccount.getId();
        this.balance = loadedAccount.getBalance();
        this.registry = loadedAccount.getRegistry();
    }

    public int getId() {
        return id;
    }

    public List<IRegistryRecord> getRegistry() {
        return registry;
    }

    public void deposit(double amount) {
        executeRecord(new Deposit(balance, amount, LocalDateTime.now()));
    }

    public void withdraw(double amount) {
        executeRecord(new Withdrawal(balance, amount, LocalDateTime.now()));
    }

    public void executeRecord(RegistryRecord record) {
        balance = record.execute();
        getRegistry().add(record);
    }

    public double getBalance() {
        return balance;
    }

    public String history() {
        StringBuilder history = new StringBuilder();
        for (IRegistryRecord record : getRegistry()) {
            history.append(record.getStatement()).append(System.getProperty("line.separator"));
        }
        return history.toString();
    }
}
