package com.poland.bank.repository;

import com.poland.bank.entity.Account;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account> {
    Optional<Account> findByIban(String iban);
}
