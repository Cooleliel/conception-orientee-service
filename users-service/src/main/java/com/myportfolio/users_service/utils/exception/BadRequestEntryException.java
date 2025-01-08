package com.myportfolio.users_service.utils.exception;

// Classe pour l'exception spécifique Requete invalide (Bad Request)
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
