package com.poland.bank.service.impl;

import com.poland.bank.entity.Account;
import com.poland.bank.entity.Transaction;
import com.poland.bank.repository.AccountRepository;
import com.poland.bank.repository.TransactionRepository;
import com.poland.bank.service.TransactionService;
import com.poland.bank.service.exception.NotEnoughMoneyException;

public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void provideTransaction(String ibanFrom, String ibanTo, int amount) {
        // in one transaction for action in database
        Account accountFrom = accountRepository.findByIban(ibanFrom).orElseThrow(IllegalArgumentException::new);
        Account accountTo = accountRepository.findByIban(ibanTo).orElseThrow(IllegalArgumentException::new);

        int currentFromAmount = accountFrom.getAmount();
        if (currentFromAmount < amount) {
            throw new NotEnoughMoneyException();
        }


        Account accountFromUpdated = new Account(accountFrom, currentFromAmount - amount);
        Account accountToUpdated = new Account(accountTo, accountTo.getAmount() + amount);

        Transaction transaction = new Transaction(accountFromUpdated, accountToUpdated, amount);

        transactionRepository.save(transaction);
        accountRepository.update(accountFromUpdated);
        accountRepository.update(accountToUpdated);

    }
}
