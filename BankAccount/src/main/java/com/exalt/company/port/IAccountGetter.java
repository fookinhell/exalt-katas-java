package com.exalt.company.port;

import com.exalt.company.domain.BankAccount;

public interface IAccountGetter {

    BankAccount load();

    void save(BankAccount bankAccount);
}
