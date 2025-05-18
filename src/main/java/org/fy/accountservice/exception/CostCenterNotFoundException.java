package org.fy.accountservice.exception;

public class CostCenterNotFoundException extends RuntimeException{

    public CostCenterNotFoundException(String message) {
        super(message);
    }
}
