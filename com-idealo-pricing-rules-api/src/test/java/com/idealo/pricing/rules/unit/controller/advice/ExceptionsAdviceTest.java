package com.idealo.pricing.rules.unit.controller.advice;

import com.idealo.pricing.rules.controller.advice.ExceptionsAdvice;
import com.idealo.pricing.rules.exceptions.InvalidRequestException;
import com.idealo.pricing.rules.exceptions.InvalidRuleRequestException;
import com.idealo.pricing.rules.exceptions.InvalidRuleTypeException;
import com.idealo.pricing.rules.model.ResponseError;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.idealo.pricing.rules.utility.DataHelper.*;
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
    public void testHandleInvalidRuleRequestException() {
        when(advice.handleInvalidRuleRequestException(any(RuntimeException.class), any()))
                .thenReturn(getHandleInvalidRuleRequestException());
        ResponseEntity<ResponseError> response = advice
                .handleInvalidRuleRequestException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        assertEquals(response.getBody().getExceptionName(), InvalidRuleRequestException.class.getName());
        verify(advice, times(1)).handleInvalidRuleRequestException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
    }

    @Test
    public void testHandleInvalidRuleTypeException() {
        when(advice.handleInvalidRuleTypeException(any(RuntimeException.class), any()))
                .thenReturn(getHandleInvalidRuleTypeException());
        ResponseEntity<ResponseError> response = advice
                .handleInvalidRuleTypeException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
        assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        assertEquals(response.getBody().getExceptionName(), InvalidRuleTypeException.class.getName());
        verify(advice, times(1)).handleInvalidRuleTypeException(TEST_RUNTIME_EXC, TEST_WEB_REQUEST);
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

}
