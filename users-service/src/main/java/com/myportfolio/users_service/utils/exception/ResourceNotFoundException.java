package com.myportfolio.users_service.utils.exception;

// Classe pour l'exception spécifique Ressource introuvable (Not Found)
public class ResourceNotFoundException extends RuntimeException{
    private final String message;

    public ResourceNotFoundException(String message) {
        this.message = message;
    }

    public ResourceNotFoundException(String entityName, String fieldName, Object value) {
        this.message = String.format(
            "'%s' avec '%s' '%s' est introuvable ou l'acces vous est refuse", entityName, fieldName, value);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
