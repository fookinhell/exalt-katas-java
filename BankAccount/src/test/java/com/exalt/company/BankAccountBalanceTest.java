package com.exalt.company;

import com.exalt.company.adapter.BankAccountController;
import com.exalt.company.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BankAccountController.class)
public class BankAccountBalanceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankAccountService service;

    @Test
    public void shouldReturnAccountBalance() throws Exception {
        when(service.getBalance(0)).thenReturn(300.0);
        this.mockMvc.perform(get("/accounts/0/balance"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("300.0")));
    }
}
