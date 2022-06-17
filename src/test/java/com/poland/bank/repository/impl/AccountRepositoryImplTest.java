package com.poland.bank.repository.impl;

import com.poland.bank.entity.Account;
import com.poland.bank.repository.DBConnector;
import com.poland.bank.repository.exception.DataBaseRuntimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountRepositoryImplTest {

    @Mock
    private DBConnector dbConnector;

    @InjectMocks
    private AccountRepositoryImpl accountRepository;

    @Test
    void findByIdShouldThrowException() throws SQLException {
        Connection connection = Mockito.mock(Connection.class);
        when(connection.prepareStatement(any())).thenThrow(SQLException.class);
        when(dbConnector.getConnection()).thenReturn(connection);

        DataBaseRuntimeException exception = assertThrows(DataBaseRuntimeException.class, () -> accountRepository.findById(1));

        assertThat(exception).hasCause(new SQLException());

    }
}
