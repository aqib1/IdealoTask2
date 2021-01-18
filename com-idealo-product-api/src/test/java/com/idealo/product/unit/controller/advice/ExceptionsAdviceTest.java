package com.idealo.product.unit.controller.advice;

import com.idealo.product.controller.advice.ExceptionsAdvice;
import com.idealo.product.exceptions.InvalidProductException;
import com.idealo.product.exceptions.InvalidRequestException;
import com.idealo.product.exceptions.StockOutOfBoundException;
import com.idealo.product.model.ResponseError;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.idealo.product.utility.DataHelper.*;
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
    public void testHandleInvalidProductException() {
        when(advice.handleInvalidProductException(any(RuntimeException.class), any()))
                .thenReturn(handleInvalidProductException());
        ResponseEntity<ResponseError> response = advice
                .handleInvalidProductException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getBody().getExceptionName(), InvalidProductException.class.getName());
        verify(advice, times(1)).handleInvalidProductException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
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
    public void testHandleStockOutOfBoundException() {
        when(advice.handleStockOutOfBoundException(any(RuntimeException.class), any()))
                .thenReturn(getHandleStockOutOfBoundException());
        ResponseEntity<ResponseError> response = advice
                .handleStockOutOfBoundException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(response.getBody().getExceptionName(), StockOutOfBoundException.class.getName());
        verify(advice, times(1)).handleStockOutOfBoundException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
    }
}
