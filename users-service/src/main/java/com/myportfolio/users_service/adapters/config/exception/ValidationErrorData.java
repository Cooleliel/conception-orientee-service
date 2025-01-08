package com.myportfolio.users_service.adapters.config.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.validation.FieldError;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

// Classe représentant les erreurs de validation
@Builder
public record ValidationErrorData(
    @Schema(example = "users") String object,
    @Schema(example = "email") String field,
    @Schema(example = "{\\\"object\\\":\\\"users\\\",\\\"field\\\":\\\"username\\\",\\\"field\\\":\\\"email\\\",\\\"field\\\":\\\"password\\\"]}") 
        Object rejectedValue,
    @Schema(example = "[Format invalide]") List<String> messages
) {
    // Constructeur pour convertir une erreur de validation Spring en ValidationErrorData
    public ValidationErrorData(FieldError error) {
        this(
            error.getObjectName(),
            error.getField(),
            error.getRejectedValue(),
            new ArrayList<>(Collections.singletonList(error.getDefaultMessage()))
        );
    }
}