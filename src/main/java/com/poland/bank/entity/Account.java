package com.poland.bank.entity;

import java.util.Objects;

public class Account {
    private final Integer id;
    private final String ibna;
    private final int amount;

    public Account(Integer id, String ibna, int amount) {
        this.id = id;
        this.ibna = ibna;
        this.amount = amount;
    }

    public Account(Account account, int amount) {
        this.id = account.id;
        this.ibna = account.ibna;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public String getIbna() {
        return ibna;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return account.amount == amount &&
                Objects.equals(id, account.id) &&
                Objects.equals(ibna, account.ibna);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ibna, amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ibna='" + ibna + '\'' +
                ", amount=" + amount +
                '}';
    }
}
