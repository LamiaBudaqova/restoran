package com.backend.restoran.exceptions;

public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.errorMessage());
    }
}