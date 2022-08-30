package com.exalt.company.service;

import com.exalt.company.domain.BankAccount;
import com.exalt.company.port.IBankOperator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService implements IBankOperator {

    private final List<BankAccount> accountList = new ArrayList<>();

    public BankAccountService() {
        BankAccount bankAccount = new BankAccount(0, 500);
        bankAccount.deposit(100); // balance = 600
        bankAccount.withdraw(300); // balance = 300
        accountList.add(bankAccount);
    }

    @Override
    public BankAccount getAccount(int id) {
        return accountList.get(id);
    }

    @Override
    public void deposit(int id, double amount) {
        accountList.get(id).deposit(amount);
    }

    @Override
    public void withdraw(int id, double amount) {
        accountList.get(id).withdraw(amount);
    }

    @Override
    public double getBalance(int id) {
        return accountList.get(id).getBalance();
    }

    @Override
    public String getHistory(int id) {
        return accountList.get(id).history();
    }
}
