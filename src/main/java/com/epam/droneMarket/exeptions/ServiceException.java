package com.epam.droneMarket.exeptions;

public class ServiceException extends Exception {

    public ServiceException() { }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
