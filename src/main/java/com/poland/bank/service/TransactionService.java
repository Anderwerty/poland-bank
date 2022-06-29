package com.poland.bank.service;

import com.poland.bank.entity.Transaction;

import java.util.List;

public interface TransactionService {

    void provideTransaction(String ibanFrom, String ibanTo, int amount);

    List<Transaction> findAll();

}
