package com.unonothing.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionType {


    // BAD_REQUEST for all input error
    // INTERNAL_SERVER_ERROR for all server error

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "{0}"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Input validation failed: {0}: {1}");

    private HttpStatus status;
    private String message;
}
