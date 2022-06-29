package com.poland.bank.injector;

import com.poland.bank.controller.MethodMap;
import com.poland.bank.controller.TransactionController;
import com.poland.bank.repository.AccountRepository;
import com.poland.bank.repository.DBConnector;
import com.poland.bank.repository.TransactionRepository;
import com.poland.bank.repository.impl.AccountRepositoryImpl;
import com.poland.bank.repository.impl.TransactionRepositoryImpl;
import com.poland.bank.service.TransactionService;
import com.poland.bank.service.impl.TransactionServiceImpl;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.apache.ibatis.io.Resources.getResourceAsReader;

public final class ContextInjector {


    ContextInjector() {
    }

    private static final DBConnector DB_CONNECTOR = new DBConnector("test");
    private static final TransactionRepository TRANSACTION_REPOSITORY = new TransactionRepositoryImpl(DB_CONNECTOR);
    private static final AccountRepository ACCOUNT_REPOSITORY = new AccountRepositoryImpl(DB_CONNECTOR);
    private static final TransactionService TRANSACTION_SERVICE = new TransactionServiceImpl(TRANSACTION_REPOSITORY, ACCOUNT_REPOSITORY);
    private static final TransactionController TRANSACTION_CONTROLLER = new TransactionController(TRANSACTION_SERVICE);

    public static final Map<String, MethodMap> URL_TO_METHOD_MAP;

    static {

        runScript("schema.sql", "data.sql");
        URL_TO_METHOD_MAP = Collections.unmodifiableMap(new RegisterForControllers().register(TRANSACTION_CONTROLLER));
    }


    private static void runScript(String... scripts) {
        ScriptRunner runner = new ScriptRunner(DB_CONNECTOR.getConnection());
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
