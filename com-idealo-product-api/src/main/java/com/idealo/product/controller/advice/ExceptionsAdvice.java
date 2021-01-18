package com.idealo.product.controller.advice;

import com.idealo.product.exceptions.InvalidProductException;
import com.idealo.product.exceptions.InvalidRequestException;
import com.idealo.product.exceptions.StockOutOfBoundException;
import com.idealo.product.model.ResponseError;
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
    public ResponseEntity<ResponseError> handleRuntimeException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (RuntimeException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(RuntimeException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<ResponseError> handleInvalidProductException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad product exception! => (InvalidProductException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(InvalidProductException.class.getName()).errorMessage(e.getMessage());
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

    @ExceptionHandler(StockOutOfBoundException.class)
    public ResponseEntity<ResponseError> handleStockOutOfBoundException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad request exception! => (StockOutOfBoundException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(StockOutOfBoundException.class.getName()).errorMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
