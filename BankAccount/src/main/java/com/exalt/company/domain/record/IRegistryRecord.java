package com.exalt.company.domain.record;

import java.time.LocalDateTime;

public interface IRegistryRecord {

    double getAmount();

    double getBalance();

    LocalDateTime getDateTime();

    String getStatement();
}
