package com.exalt.company.domain.record;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class RegistryRecord implements IRegistryRecord {

    public enum RecordType {
        DEPOSIT,
        WITHDRAWAL
    }

    private final RecordType recordType;
    protected double balance;
    protected final double amount;
    private final LocalDateTime localDateTime;

    public RegistryRecord(RecordType type, double balance, double amount, LocalDateTime dateTime) {
        this.recordType = type;
        this.balance = balance;
        this.amount = amount;
        this.localDateTime = dateTime;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public LocalDateTime getDateTime() {
        return localDateTime;
    }

    @Override
    public String getStatement() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        String sign = (recordType == RecordType.DEPOSIT) ? "+" : "-";
        return "[" + dtf.format(localDateTime) + "]"
                + " record type : " + recordType.toString()
                + ", amount : " + sign + amount
                + ", new balance : " +balance;
    }

    public abstract double execute();
}

