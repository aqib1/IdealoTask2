package com.idealo.checkout.unit.service;

import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.service.Impl.CheckoutServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.checkout.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CheckoutServiceImplTest {
    @Mock
    private CheckoutServiceImpl service;

    @Test
    public void testCheckout() {
        when(service.checkout(any(CheckoutRequest.class)))
                .thenReturn(ruleResponse());
        assertEquals(service.checkout(checkoutRequest()), ruleResponse());
        verify(service, times(1)).checkout(checkoutRequest());
    }
}
