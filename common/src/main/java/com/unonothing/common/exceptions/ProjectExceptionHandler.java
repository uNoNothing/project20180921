package com.unonothing.common.exceptions;

import com.unonothing.common.dto.BaseEntityDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice("com.unonothing")
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    // catch exceptions raised in project
    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<BaseEntityDTO> handleProjectException(ProjectException ex){

        log.error("Exception caught at handleProjectException. ex: ", ex);
        return handler(ex, ex.getHttpStatus());
    }

    // catch null pointer exception
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<BaseEntityDTO> handleNullPointerException(NullPointerException ex){

        log.error("Exception caught at handleNullPointerException. ex: ", ex);
        return handler(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // catch all other exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseEntityDTO> handleException(Exception ex){

        log.error("Exception caught at handleException. ex: ", ex);
        return handler(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<BaseEntityDTO> handler(Exception ex, HttpStatus httpStatus) {
        return new ResponseEntity<>(createBaseDTO(ex), httpStatus);
    }

    private BaseEntityDTO createBaseDTO(Exception ex){
        log.error(ex.getMessage());

        BaseEntityDTO baseEntityDTO = new BaseEntityDTO();
        baseEntityDTO.setError(true);
        baseEntityDTO.setMessage(ex.getMessage());

        return baseEntityDTO;
    }


}
