package com.idealo.checkout.unit.clients;

import com.idealo.checkout.clients.ProductClient;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.GetProductBySkuResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.checkout.utility.DataHelper.checkoutRequest;
import static com.idealo.checkout.utility.DataHelper.getProductBySkuResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductClientTest {

    @Mock
    private ProductClient productClient;

    @Test
    public void testGetAllBySku() {
        when(productClient.getAllBySku(any(CheckoutRequest.class)))
        .thenReturn(getProductBySkuResponse());

        GetProductBySkuResponse response = productClient.getAllBySku(checkoutRequest());
        assertEquals(response, getProductBySkuResponse());
        verify(productClient, times(1)).getAllBySku(checkoutRequest());
    }
}
