package com.idealo.checkout.controller.advice;

import com.idealo.checkout.exception.BadRequestException;
import com.idealo.checkout.exception.InternalServiceException;
import com.idealo.checkout.exception.InvalidRequestException;
import com.idealo.checkout.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * <p>
 * This is the class for idealo exceptions advices
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */

@RestControllerAdvice
public class ExceptionsAdvice {
    @ExceptionHandler(value
            = {RuntimeException.class, IllegalStateException.class})
    protected ResponseEntity<ResponseError> handleRuntimeException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (RuntimeException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(RuntimeException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidRequestException.class)
    protected ResponseEntity<ResponseError> handleInvalidRequestException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (InvalidRequestException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(InvalidRequestException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ResponseError> handleBadRequestException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (BadRequestException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(BadRequestException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServiceException.class)
    protected ResponseEntity<ResponseError> handleInternalServiceException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (InternalServiceException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(InternalServiceException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
