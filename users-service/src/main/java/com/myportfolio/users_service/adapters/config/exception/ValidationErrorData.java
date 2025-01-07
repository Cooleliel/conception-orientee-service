package com.myportfolio.users_service.adapters.config.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.validation.FieldError;

import lombok.Builder;

@Builder
public record ValidationErrorData(
    String object,
    String filed,
    Object rejectedValue,
    List<String> messages
) {
    
    public ValidationErrorData(FieldError error) {
        this(
            error.getObjectName(),
            error.getField(),
            error.getRejectedValue(),
            new ArrayList<>(Collections.singletonList(error.getDefaultMessage()))
        );
    }
}
