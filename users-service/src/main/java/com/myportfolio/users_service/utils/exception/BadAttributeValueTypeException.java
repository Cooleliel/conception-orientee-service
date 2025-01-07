package com.myportfolio.users_service.utils.exception;

public class BadAttributeValueTypeException extends RuntimeException{
    private final String message;

    public BadAttributeValueTypeException(String attribute, String type) {
        this.message = String.format("'%s' doit etre de type '%s'", attribute, type);
    }

    public BadAttributeValueTypeException(String option) {
        this.message = String.format("'%s' n'est pas un format valide pour cet attribut", option);
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
