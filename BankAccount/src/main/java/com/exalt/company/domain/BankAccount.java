package com.exalt.company.domain;


import com.exalt.company.port.IAccountGetter;
import com.exalt.company.port.IBankOperator;
import com.exalt.company.domain.record.Deposit;
import com.exalt.company.domain.record.IRegistryRecord;
import com.exalt.company.domain.record.RegistryRecord;
import com.exalt.company.domain.record.Withdrawal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount implements IBankOperator {

    private long id;
    private double currentBalance;

    private final List<IRegistryRecord> registry;

    public BankAccount(long id, double initBalance) {
        this.id = id;
        this.currentBalance = initBalance;
        this.registry = new ArrayList<>();
    }

    public BankAccount(IAccountGetter getter) {
        BankAccount loadedAccount = getter.load();
        this.id = loadedAccount.getId();
        this.currentBalance = loadedAccount.getBalance();
        this.registry = loadedAccount.getRegistry();
    }

    public List<IRegistryRecord> getRegistry() {
        return registry;
    }
    @Override
    public void deposit(double amount) {
        executeRecord(new Deposit(currentBalance, amount, LocalDateTime.now()));
    }

    @Override
    public void withdraw(double amount) {
        executeRecord(new Withdrawal(currentBalance, amount, LocalDateTime.now()));
    }

    public void executeRecord(RegistryRecord record) {
        currentBalance = record.execute();
        registry.add(record);
    }

    @Override
    public double getBalance() {
        return currentBalance;
    }

    @Override
    public String getHistory() {
        StringBuilder history = new StringBuilder();
        for (IRegistryRecord record : registry) {
            history.append(record.getStatement()).append(System.getProperty("line.separator"));
        }
        return history.toString();
    }

    public long getId() {
        return id;
    }
}
