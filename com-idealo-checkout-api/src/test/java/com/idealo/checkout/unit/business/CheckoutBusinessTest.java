package com.idealo.checkout.unit.business;

import com.idealo.checkout.business.CheckoutBusiness;
import com.idealo.checkout.exception.InvalidRequestException;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.RuleResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.idealo.checkout.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CheckoutBusinessTest {
    @Mock
    private CheckoutBusiness business;

    @Test
    public void testCheckout() {
        when(business.checkout(any(CheckoutRequest.class))).thenReturn(ruleResponse());

        RuleResponse response = business.checkout(checkoutRequest());
        assertEquals(response, ruleResponse());
        verify(business, times(1)).checkout(checkoutRequest());
    }

    @Test
    public void testCheckoutWithNullRequest() {
        when(business.checkout(isNull())).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class,() -> {
            business.checkout(null);
        });

        verify(business, times(1)).checkout(null);
    }

    @Test
    public void testCheckoutWithInvalidRequest() {
        when(business.checkout(any(CheckoutRequest.class))).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class,() -> {
            business.checkout(checkoutRequestInvalid());
        });

        verify(business, times(1)).checkout(checkoutRequestInvalid());
    }
}
