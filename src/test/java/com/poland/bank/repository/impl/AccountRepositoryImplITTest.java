package com.poland.bank.repository.impl;

import com.poland.bank.entity.Account;
import com.poland.bank.repository.AccountRepository;
import com.poland.bank.repository.DBConnector;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.apache.ibatis.io.Resources.getResourceAsReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountRepositoryImplITTest {
    private final DBConnector dbConnector = new DBConnector("test");
    private final AccountRepository accountRepository = new AccountRepositoryImpl(dbConnector);
    private ScriptRunner runner;

    @BeforeEach
    void initBD() {
        runScript("schema.sql", "data.sql");
    }

    @AfterEach
    void clean(){
        runner.closeConnection(); // or drop is exist in script
    }

    @Test
    void findByIdShouldReturnAccount() {
        Account expectedAccount = new Account(1, "00001", 10);
        Account actualAccount = accountRepository.findById(1).get();

        assertEquals(expectedAccount, actualAccount);
    }


    @Test
    void updateMethodShouldUpdateAccount() {
        Account expectedAccount = new Account(1, "00001", 1234);
        accountRepository.update(expectedAccount);
        Account actualAccount = accountRepository.findById(1).get();

        assertEquals(expectedAccount, actualAccount);
    }

    private void runScript(String... scripts) {
        runner = new ScriptRunner(dbConnector.getConnection());
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        Arrays.stream(scripts).forEach(script -> {
            try {
                runner.runScript(getResourceAsReader(script));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}