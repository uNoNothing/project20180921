package com.unonothing.common.exceptions;

import com.unonothing.common.dto.BaseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;


@ControllerAdvice("com.unonothing")
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandler.class);


    // catch validation exceptions
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<BaseDTO> handleValidationException(ValidationException ex) {

        log.error("Exception caught at handleValidationException.");

        return handler(ex.getCause().getMessage(), HttpStatus.BAD_REQUEST);
    }

    // catch null pointer exception
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<BaseDTO> handleNullPointerException(NullPointerException ex) {

        log.error("Exception caught at handleNullPointerException.", ex);
        return handler(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // catch SQL Data Integrity Violation Exception
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<BaseDTO> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {

        log.error("Exception caught at handleDataIntegrityViolationException.");
        return handler(ex.getCause().getCause().getMessage(), HttpStatus.BAD_REQUEST);
    }


    // catch SQL Constraint Violation Exception
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseDTO> handleConstraintViolationException(ConstraintViolationException ex) {

        log.error("Exception caught at handleConstraintViolationException.");

        String errorMessage = "";
        if (ex.getConstraintViolations().iterator().hasNext()) {
            ConstraintViolation constraintViolation = ex.getConstraintViolations().iterator().next();

            String field = constraintViolation.getPropertyPath().toString();
//            String invalidValue = constraintViolation.getInvalidValue().toString();
            String message = constraintViolation.getMessage();

            errorMessage = message.concat(" for ").concat(field);
        }

        log.error(errorMessage);

        return handler(errorMessage, HttpStatus.BAD_REQUEST);
    }

    // catch exceptions raised in project
    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<BaseDTO> handleProjectException(ProjectException ex) {

        if ((ex.getHttpStatus().compareTo(HttpStatus.BAD_REQUEST) == 0)
                || (ex.getHttpStatus().compareTo(HttpStatus.NO_CONTENT) == 0)) {
            log.error("Exception caught at handleProjectException.");
        } else {
            log.error("Exception caught at handleProjectException.", ex);
        }
        return handler(ex.getMessage(), ex.getHttpStatus());
    }

    // catch all other exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseDTO> handleException(Exception ex) {

        log.error("Exception caught at handleException.", ex);
        return handler(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<BaseDTO> handler(String message, HttpStatus httpStatus) {
        return new ResponseEntity<>(createBaseDTO(message), httpStatus);
    }

    private BaseDTO createBaseDTO(String message) {
//        log.error(ex.getMessage());

        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setError(true);
        baseDTO.setMessage(message);

        return baseDTO;
    }


}
