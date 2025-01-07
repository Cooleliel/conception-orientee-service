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

@Builder
public record HttpErrorResponse(
    int status,
    String errorMessage,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<ValidationErrorData> validationErrors,
    String exception,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDateTime dateTime,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String path
) {
    
}
