package com.exalt.company.adapter;

import com.exalt.company.domain.BankAccount;
import com.exalt.company.port.IBankOperator;
import com.exalt.company.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {

    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public BankAccount getAccount(@PathVariable("id") final int id) {
        return service.getAccount(id);
    }

    @PostMapping(value = "/{id}/deposit/{amount}")
    void deposit(@PathVariable final int id, @PathVariable final double amount) {
        service.deposit(id, amount);
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    void withdraw(@PathVariable final int id, @PathVariable final double amount) {
        service.withdraw(id, amount);
    }

    @GetMapping(value = "/{id}/balance")
    public Double balance(@PathVariable final int id) {
        return service.getBalance(id);
    }

    @GetMapping(value = "/{id}/history")
    public String history(@PathVariable final int id) {
        return service.getHistory(id);
    }
}
