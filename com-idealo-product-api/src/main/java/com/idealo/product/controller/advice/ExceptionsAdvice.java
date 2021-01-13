package com.idealo.product.controller.advice;
import com.idealo.product.exceptions.InvalidProductException;
import com.idealo.product.exceptions.InvalidRequestException;
import com.idealo.product.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

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
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ResponseEntity<ResponseError>> handleRuntimeException(Throwable e) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (RuntimeException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(RuntimeException.class.getName()).errorMessage(e.getMessage());
        return Mono.just(new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(InvalidProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ResponseEntity<ResponseError>> handleInvalidProductException(Throwable e) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad product exception! => (InvalidProductException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(InvalidProductException.class.getName()).errorMessage(e.getMessage());
        return Mono.just(new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ResponseEntity<ResponseError>> handleInvalidRequestException(Throwable e) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad request exception! => (InvalidRequestException)]";
        ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(InvalidRequestException.class.getName()).errorMessage(e.getMessage());
        return Mono.just(new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST));
    }
}
