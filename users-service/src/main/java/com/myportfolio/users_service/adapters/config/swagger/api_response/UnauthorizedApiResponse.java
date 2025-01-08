package com.myportfolio.users_service.adapters.config.swagger.api_response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.myportfolio.users_service.adapters.config.exception.HttpErrorResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

// Annotation personnalisée pour gérer les réponses HTTP 401 (Non autorisé)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
    responseCode = "401",
    description = "Authentification requise",
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = HttpErrorResponse.class))
)
public @interface UnauthorizedApiResponse {}
