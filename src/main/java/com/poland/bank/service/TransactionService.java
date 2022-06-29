package com.poland.bank.service;

public interface TransactionService {

    void provideTransaction(String ibanFrom, String ibanTo, int amount);

}
