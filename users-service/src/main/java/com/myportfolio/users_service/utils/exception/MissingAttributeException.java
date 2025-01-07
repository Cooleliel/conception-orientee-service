package com.myportfolio.users_service.utils.exception;

public class MissingAttributeException extends RuntimeException{
    private final String message;

    public MissingAttributeException() {
        this.message = "Attribut requis manquant";
    }

    public MissingAttributeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
