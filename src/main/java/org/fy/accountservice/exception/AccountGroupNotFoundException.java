package org.fy.accountservice.exception;

public class AccountGroupNotFoundException extends RuntimeException{

    public AccountGroupNotFoundException(String message) {
        super(message);
    }
}
