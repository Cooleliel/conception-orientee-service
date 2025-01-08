package com.myportfolio.users_service.adapters.config.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Builder;

// Classe pour les réponses HTTP d'erreur standardisées
@Builder
public record HttpErrorResponse(
    /*@Schema(example = "401")*/ 
    int status, // Code HTTP de l'erreur

    /*@Schema(example = "Authentification requise")*/ 
    String errorMessage, // Message d'erreur

    @JsonInclude(JsonInclude.Include.NON_NULL)
    /*@Schema(example = "[{\"object\":\"users\",\"field\":\"email\",\"rejectedValue\":\"invalid-email\",\"messages\":[\"Format invalide\"]}]")*/
    List<ValidationErrorData> validationErrors, // Liste des erreurs de validation

    /*@Schema(example = "org.example.exceptions.UnauthorizedException")*/ 
    String exception, // Classe d'exception levée

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    /*@Schema(example = "06-01-2025 14:23:45")*/ 
    LocalDateTime dateTime, // Date et heure de l'erreur

    @JsonInclude(JsonInclude.Include.NON_NULL)
    /*@Schema(example = "/api/users/register")*/ String path // Chemin de l'endpoint où l'erreur est survenue
) {}
