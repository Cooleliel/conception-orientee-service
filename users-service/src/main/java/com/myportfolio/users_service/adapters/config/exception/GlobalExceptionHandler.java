package com.myportfolio.users_service.adapters.config.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import com.myportfolio.users_service.utils.exception.BadAttributeValueTypeException;
import com.myportfolio.users_service.utils.exception.BadRequestEntryException;
import com.myportfolio.users_service.utils.exception.ConflictingOperationException;
import com.myportfolio.users_service.utils.exception.ForbiddenOperationException;
import com.myportfolio.users_service.utils.exception.MissingAttributeException;
import com.myportfolio.users_service.utils.exception.ResourceNotFoundException;
import com.myportfolio.users_service.utils.exception.UnauthorizedException;

@RestControllerAdvice // Cette annotation permet de définir une classe qui gère les exceptions globalement pour tous les contrôleurs de l'application
public class GlobalExceptionHandler {

    // Gestion de l'exception BadRequestEntryException
    @ExceptionHandler(BadRequestEntryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Code HTTP 400 pour un attribut mal formate
    public HttpErrorResponse handleBadRequestEntryException(BadRequestEntryException ex) {
        return new HttpErrorResponse(
            400,
            ex.getMessage(),
            null,
            ex.getClass().getSimpleName(),
            LocalDateTime.now(),
            null
        );
    }

    // Gestion de l'exception MissingAttributeException
    @ExceptionHandler(MissingAttributeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Code HTTP 400 pour un attribut manquant
    public HttpErrorResponse handleMissingAttributeException(MissingAttributeException ex) {
        return new HttpErrorResponse(
            400,
            ex.getMessage(),
            null,
            ex.getClass().getSimpleName(),
            LocalDateTime.now(),
            null
        );
    }

    // Gestion de l'exception BadAttributeValueTypeException
    @ExceptionHandler(BadAttributeValueTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Code HTTP 400 pour un type d'attribut invalide
    public HttpErrorResponse handleBadAttributeValueTypeException(BadAttributeValueTypeException ex) {
        return new HttpErrorResponse(
            400,
            ex.getMessage(),
            null,
            ex.getClass().getSimpleName(),
            LocalDateTime.now(),
            null
        );
    }

    // Gestion de l'exception ConflictingOperationException
    @ExceptionHandler(ConflictingOperationException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // Code HTTP 409 pour une opération de conflit
    public HttpErrorResponse handleConflictingOperationException(ConflictingOperationException ex) {
        return new HttpErrorResponse(
            409,
            ex.getMessage(),
            null,
            ex.getClass().getSimpleName(),
            LocalDateTime.now(),
            null
        );
    }

    // Gestion de l'exception ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Code HTTP 404 pour une ressource non trouvee
    public HttpErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new HttpErrorResponse(
            404,
            ex.getMessage(),
            null,
            ex.getClass().getSimpleName(),
            LocalDateTime.now(),
            null
        );
    }

    // Gestion de l'exception UnauthorizedException
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // Code HTTP 401 pour une authentification requise
    public HttpErrorResponse handleUnauthorizedException(UnauthorizedException ex) {
        return new HttpErrorResponse(
            401,
            ex.getMessage(),
            null,
            ex.getClass().getSimpleName(),
            LocalDateTime.now(),
            null
        );
    }

    // Gestion de l'exception ForbiddenOperationException
    @ExceptionHandler(ForbiddenOperationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN) // Code HTTP 403 pour une opération interdite
    public HttpErrorResponse handleForbiddenOperationException(ForbiddenOperationException ex) {
        return new HttpErrorResponse(
            403,
            ex.getMessage(),
            null,
            ex.getClass().getSimpleName(),
            LocalDateTime.now(),
            null
        );
    }
}

