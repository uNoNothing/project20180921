package com.unonothing.common.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class ExceptionFactory {

    private final static Logger log = LoggerFactory.getLogger(ExceptionFactory.class);

    public static ProjectException create(final Throwable cause, final ExceptionType exceptionType,
                                          final Object... messageArguments) {
        log.error(MessageFormat.format(exceptionType.getMessage(), messageArguments), cause);
        return new ProjectException(cause, exceptionType, messageArguments);
    }

    public static ProjectException create(final ExceptionType exceptionType, final Object... messageArguments) {
        log.error(MessageFormat.format(exceptionType.getMessage(), messageArguments));
        return new ProjectException(exceptionType, messageArguments);
    }
}
