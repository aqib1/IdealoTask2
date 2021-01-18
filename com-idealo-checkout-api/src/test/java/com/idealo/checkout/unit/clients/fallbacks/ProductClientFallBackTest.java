package com.idealo.checkout.unit.clients.fallbacks;

import com.idealo.checkout.clients.fallbacks.ProductClientFallBack;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static com.idealo.checkout.utility.DataHelper.productClient;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductClientFallBackTest {
    @Mock
    private ProductClientFallBack productClientFallBack;

    @Test
    public void testCreate() {
        when(productClientFallBack.create(any(Throwable.class)))
                .thenReturn(productClient());
        Exception e = new Exception();
        productClientFallBack.create(e);
        verify(productClientFallBack, times(1)).create(e);
    }
}
