package com.exalt.company;

import com.exalt.company.adapter.BankAccountController;
import com.exalt.company.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BankAccountAppTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankAccountController controller;

    @Test
    public void contextLoads() throws Exception {
        mockMvc.perform(get("/accounts/0")).andDo(print());
        assertThat(controller).isNotNull();
    }


    @Test
    public void shouldReturnAccountBalance() throws Exception {
        mockMvc.perform(get("/accounts/0/balance"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("300.0"));
    }

}
