package com.idealo.checkout.unit.clients;

import com.idealo.checkout.clients.RuleInfoClient;
import com.idealo.checkout.model.RuleRequest;
import com.idealo.checkout.model.RuleResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.checkout.utility.DataHelper.ruleRequest;
import static com.idealo.checkout.utility.DataHelper.ruleResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RuleInfoClientTest {

    @Mock
    private RuleInfoClient ruleInfoClient;

    @Test
    public void pricingRulesTest() {
        when(ruleInfoClient.pricingRules(any(RuleRequest.class)))
                .thenReturn(ruleResponse());
        RuleResponse response = ruleInfoClient.pricingRules(ruleRequest());
        assertEquals(response, ruleResponse());
        verify(ruleInfoClient, times(1)).pricingRules(ruleRequest());
    }
}
