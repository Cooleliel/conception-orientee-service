package com.myportfolio.users_service.utils.exception;

public class ForbiddenOperationException extends RuntimeException{
    private final String message;

    public ForbiddenOperationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
