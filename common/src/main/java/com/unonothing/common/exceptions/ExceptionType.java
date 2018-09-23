package com.unonothing.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionType {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "{0}"),
    ENUM_ERROR(HttpStatus.BAD_REQUEST, "Invalid {0}");

    private HttpStatus status;
    private String message;
}
