package com.csc625.checkin.exceptions.handler;


import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.csc625.checkin.exceptions.BadRequestException;
import com.csc625.checkin.exceptions.NotFoundException;
import com.fasterxml.jackson.databind.JsonMappingException;



@ControllerAdvice
public class GlobalRestExceptionHandler extends DefaultHandlerExceptionResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHandlerExceptionResolver.class);
    private final DefaultResponseEntityExceptionHandler responseEntExcHandler = new DefaultResponseEntityExceptionHandler();
    
    public final ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        return responseEntExcHandler.handleException(ex, request);
    }

    @ExceptionHandler(value = { NotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(RuntimeException e, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return handleException(e, status, request);
    }
    
    @ExceptionHandler(value = { BadRequestException.class })
    protected ResponseEntity<Object> handleRadRequest(RuntimeException e, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return handleException(e, status, request);
    }

    private ResponseEntity<Object> handleException(RuntimeException e, HttpStatus status, WebRequest request) {
        String message = e.getMessage() != null ? e.getMessage() : status.getReasonPhrase();
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            LOGGER.error(e.getMessage(), e);
            message = "An unexpected error has occurred. Please try again later.";
        } else if (HttpStatus.BAD_REQUEST.equals(status) || HttpStatus.NOT_FOUND.equals(status)) {
            LOGGER.debug(e.getMessage());
        } else if (HttpStatus.SERVICE_UNAVAILABLE.equals(status)) {
            LOGGER.error(e.getMessage(), e);
        } else {
            LOGGER.debug(e.getMessage(), e);
        }
        // Brock T 12/25/17 - Wrap all exception messages as json so Angular can parse it.
        message = "{\"error\": \"" + message + "\"}";

        return this.responseEntExcHandler.doHandleExceptionInternal(e, message, new HttpHeaders(), status, request);
    }

}