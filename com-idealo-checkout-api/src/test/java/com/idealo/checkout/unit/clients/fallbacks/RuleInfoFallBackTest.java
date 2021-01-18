package com.idealo.checkout.unit.clients.fallbacks;

import com.idealo.checkout.clients.fallbacks.RuleInfoFallBack;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.checkout.utility.DataHelper.ruleInfoClient;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RuleInfoFallBackTest {
    @Mock
    private RuleInfoFallBack fallBack;

    @Test
    public void createTest() {
        when(fallBack.create(any(Throwable.class)))
                .thenReturn(ruleInfoClient());
        Exception e = new Exception();
        fallBack.create(e);
        verify(fallBack, times(1)).create(e);
    }
}
