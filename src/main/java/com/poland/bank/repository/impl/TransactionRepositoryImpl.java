package com.poland.bank.repository.impl;

import com.poland.bank.entity.Transaction;
import com.poland.bank.repository.DBConnector;
import com.poland.bank.repository.TransactionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRepositoryImpl extends AbstractCrudRepository<Transaction> implements TransactionRepository {
    private static final String SAVE_QUERY = "INSERT INTO accounts (iban, amount) values(?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM accounts WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM account";// error in the query
    private static final String UPDATE_QUERY = "UPDATE accounts SET iban =?, amount=? WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM accounts WHERE id = ?";

    public TransactionRepositoryImpl(DBConnector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    protected void mapEntityToPreparedStatementForSave(PreparedStatement preparedStatement, Transaction entity) throws SQLException {

    }

    @Override
    protected Transaction mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, Transaction entity) throws SQLException {

    }
}
