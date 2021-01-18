package com.idealo.checkout.unit.controller.advice;

import com.idealo.checkout.controller.advice.ExceptionsAdvice;
import com.idealo.checkout.exception.BadRequestException;
import com.idealo.checkout.exception.InternalServiceException;
import com.idealo.checkout.exception.InvalidRequestException;
import com.idealo.checkout.model.ResponseError;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.idealo.checkout.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ExceptionsAdviceTest {

    @Mock
    private ExceptionsAdvice advice;

    @Test
    public void testHandleRuntimeException() {
        when(advice.handleRuntimeException(any(RuntimeException.class), any()))
                .thenReturn(getHandlerRuntimeException());
        ResponseEntity<ResponseError> response = advice
                .handleRuntimeException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(response.getBody().getExceptionName(), IllegalStateException.class.getName());
        verify(advice, times(1)).handleRuntimeException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);

    }

    @Test
    public void testHandleInvalidRequestException() {
        when(advice.handleInvalidRequestException(any(RuntimeException.class), any()))
                .thenReturn(getHandleInvalidRequestException());
        ResponseEntity<ResponseError> response = advice
                .handleInvalidRequestException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(response.getBody().getExceptionName(), InvalidRequestException.class.getName());
        verify(advice, times(1)).handleInvalidRequestException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
    }

    @Test
    public void testHandleBadRequestException() {
        when(advice.handleBadRequestException(any(RuntimeException.class), any()))
                .thenReturn(getHandleBadRequestException());
        ResponseEntity<ResponseError> response = advice
                .handleBadRequestException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getBody().getExceptionName(), BadRequestException.class.getName());
        verify(advice, times(1)).handleBadRequestException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
    }

    @Test
    public void testHandleInternalServiceException() {
        when(advice.handleInternalServiceException(any(RuntimeException.class), any()))
                .thenReturn(getHandleInternalServiceException());
        ResponseEntity<ResponseError> response = advice
                .handleInternalServiceException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(response.getBody().getExceptionName(), InternalServiceException.class.getName());
        verify(advice, times(1)).handleInternalServiceException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
    }
}
