package com.idealo.checkout.unit.service;

import com.idealo.checkout.exception.BadRequestException;
import com.idealo.checkout.exception.InternalServiceException;
import com.idealo.checkout.service.Impl.FeignErrorDecoder;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FeignErrorDecoderTest {

    @Mock
    private FeignErrorDecoder feignErrorDecoder;

    @Test
    public void decodeInternalServiceTest() {
        when(feignErrorDecoder.decode(anyString(),any())).thenThrow(new InternalServiceException());
        assertThrows(InternalServiceException.class, () -> {
            feignErrorDecoder.decode("", null);
        });
        verify(feignErrorDecoder, times(1)).decode("", null);
    }

    @Test
    public void decodeBadRequestTest() {
        when(feignErrorDecoder.decode(anyString(),any())).thenThrow(new BadRequestException());
        assertThrows(BadRequestException.class, () -> {
            feignErrorDecoder.decode("", null);
        });
        verify(feignErrorDecoder, times(1)).decode("", null);
    }

    @Test
    public void decodeIllegalStateExceptionTest() {
        when(feignErrorDecoder.decode(anyString(),any())).thenThrow(new IllegalStateException());
        assertThrows(IllegalStateException.class, () -> {
            feignErrorDecoder.decode("", null);
        });
        verify(feignErrorDecoder, times(1)).decode("", null);
    }
}
