package com.myportfolio.users_service.utils.exception;

// Classe pour l'exception spécifique Conflit (Conflicting Operation)
public class ConflictingOperationException extends RuntimeException{
    private final String message;

    public ConflictingOperationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
