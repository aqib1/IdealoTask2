package com.idealo.checkout.unit.controller;

import com.idealo.checkout.controller.CheckoutController;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.RuleResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.idealo.checkout.utility.DataHelper.checkoutRequest;
import static com.idealo.checkout.utility.DataHelper.ruleResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CheckoutControllerTest {

    @Mock
    private CheckoutController controller;

    @Test
    public void testCheckout() {
        when(controller.checkout(any(CheckoutRequest.class))).thenReturn(
                ResponseEntity.ok(ruleResponse()));

        ResponseEntity<RuleResponse> response = controller.checkout(checkoutRequest());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), ruleResponse());
        verify(controller, times(1)).checkout(checkoutRequest());
    }
}
