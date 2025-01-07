package com.myportfolio.users_service.utils.exception;

public class BadRequestEntryException extends RuntimeException{
    private final String message;

    public BadRequestEntryException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
