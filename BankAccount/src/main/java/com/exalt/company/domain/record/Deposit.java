package com.exalt.company.domain.record;

import java.time.LocalDateTime;

public class Deposit extends RegistryRecord {

    public Deposit(double balance, double amount, LocalDateTime dateTime) {
        super(RecordType.DEPOSIT, balance, amount, dateTime);
    }

    @Override
    public double execute() {
        return balance += amount;
    }
}
