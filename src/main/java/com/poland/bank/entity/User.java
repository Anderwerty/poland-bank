package com.poland.bank.entity;

import java.util.Objects;

public class User {
    private final Integer id;
    private final String email;
    private final String password;
    private final Account account;

    public User(Integer id, String email, String password, Account account) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password)&&
                Objects.equals(account, user.account);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}
