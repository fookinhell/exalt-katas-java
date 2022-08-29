package com.exalt.company.domain.record;

import java.time.LocalDateTime;

public class Withdrawal extends RegistryRecord {

    public Withdrawal(double balance, double amount, LocalDateTime dateTime) {
        super(RecordType.WITHDRAWAL, balance, amount, dateTime);
    }

    @Override
    public double execute() {
        return balance - amount;
    }
}
