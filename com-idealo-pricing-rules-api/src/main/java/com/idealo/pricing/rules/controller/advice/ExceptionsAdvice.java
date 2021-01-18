package com.idealo.pricing.rules.controller.advice;

import com.idealo.pricing.rules.exceptions.InvalidRequestException;
import com.idealo.pricing.rules.exceptions.InvalidRuleRequestException;
import com.idealo.pricing.rules.exceptions.InvalidRuleTypeException;
import com.idealo.pricing.rules.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
public class ExceptionsAdvice {

    @ExceptionHandler(value
            = {RuntimeException.class, IllegalStateException.class})
    public ResponseEntity<ResponseError> handleRuntimeException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (RuntimeException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(RuntimeException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidRuleRequestException.class)
    public ResponseEntity<ResponseError> handleInvalidRuleRequestException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad product exception! => (InvalidRuleException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(InvalidRuleRequestException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ResponseError> handleInvalidRequestException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad request exception! => (InvalidRequestException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(InvalidRequestException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRuleTypeException.class)
    public ResponseEntity<ResponseError> handleInvalidRuleTypeException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad request exception! => (InvalidRuleTypeException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(InvalidRuleTypeException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
