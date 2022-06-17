package com.poland.bank.entity;

import java.util.Objects;

public class Transaction {
    private final Integer id;
    private final Account accountFrom;
    private final Account accountTo;
    private final double amount;

    public Transaction(Integer id, Account accountFrom, Account accountTo, double amount) {
        this.id = id;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(id, that.id) && Objects.equals(accountFrom, that.accountFrom) && Objects.equals(accountTo, that.accountTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountFrom, accountTo, amount);
    }
}
