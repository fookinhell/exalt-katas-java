package com.exalt.company.adapter;

import com.exalt.company.domain.BankAccount;
import com.exalt.company.port.IBankOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {

    @Autowired
    private IBankOperator bankOperator;

    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public BankAccount getAccount(@PathVariable("id") final int id) {
        return bankOperator.getAccount(id);
    }

    @PostMapping(value = "/{id}/deposit/{amount}")
    void deposit(@PathVariable final int id, @PathVariable final double amount) {
        bankOperator.deposit(id, amount);
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    void withdraw(@PathVariable final int id, @PathVariable final double amount) {
        bankOperator.withdraw(id, amount);
    }

    @GetMapping(value = "/{id}/balance")
    public Double balance(@PathVariable final int id) {
        return bankOperator.getBalance(id);
    }

    @GetMapping(value = "/{id}/history")
    public String history(@PathVariable final int id) {
        return bankOperator.getHistory(id);
    }
}
