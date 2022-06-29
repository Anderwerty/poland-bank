package com.poland.bank.repository.impl;

import com.poland.bank.entity.Account;
import com.poland.bank.repository.AccountRepository;
import com.poland.bank.repository.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AccountRepositoryImpl extends AbstractCrudRepository<Account> implements AccountRepository {

    private static final String SAVE_QUERY = "INSERT INTO accounts (iban, amount) values(?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM accounts WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM account";// error in the query
    private static final String UPDATE_QUERY = "UPDATE accounts SET iban =?, amount=? WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM accounts WHERE id = ?";

    public AccountRepositoryImpl(DBConnector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    public Optional<Account> findByIban(String iban) {
        //should be implemented
        return Optional.empty();
    }

    @Override
    protected void mapEntityToPreparedStatementForSave(PreparedStatement preparedStatement, Account entity) throws SQLException {
        preparedStatement.setString(1, entity.getIbna());
        preparedStatement.setDouble(2, entity.getAmount());
    }

    @Override
    protected Account mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Account(resultSet.getInt("id"),
                resultSet.getString("iban"),
                resultSet.getInt("amount"));
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, Account entity) throws SQLException {
        mapEntityToPreparedStatementForSave(preparedStatement, entity);
        preparedStatement.setInt(3, entity.getId());
    }
}
