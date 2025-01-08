package com.myportfolio.users_service.utils.exception;

// Classe pour l'exception spécifique (Forbidden Request)
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
