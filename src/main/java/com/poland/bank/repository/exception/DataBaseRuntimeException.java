package com.poland.bank.repository.exception;

public class DataBaseRuntimeException extends RuntimeException{
    public DataBaseRuntimeException(String message) {
        super(message);
    }

    public DataBaseRuntimeException(Throwable cause) {
        super(cause);
    }
}
