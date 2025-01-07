package com.myportfolio.users_service.utils.exception;

public class UnauthorizedException extends RuntimeException{
    private final String message;

    public UnauthorizedException() {
        this.message = "Impossible d'obtenir les informations d'authentification";
    }

    public UnauthorizedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
