package com.poland.bank.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E> {
    void save(E entity);

    Optional<E> findById(Integer id);

    List<E> findAll();

    void update(E entity);

    void deleteById(Integer id);
}
