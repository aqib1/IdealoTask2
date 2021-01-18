package com.idealo.pricing.rules.unit.data.Impl;

import com.idealo.pricing.rules.data.Impl.FreeShippingRule;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfoRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.pricing.rules.utility.DataHelper.ruleEntity;
import static com.idealo.pricing.rules.utility.DataHelper.ruleInfoRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FreeShippingRuleTest {
    @Mock
    private FreeShippingRule freeShippingRule;

    @Test
    public void testApplyRules() {
        when(freeShippingRule.applyRule(any(RuleInfoRequest.class),any(RuleEntity.class)))
                .thenReturn(50L);
        assertEquals(freeShippingRule.applyRule(ruleInfoRequest(), ruleEntity()), 50L);
        verify(freeShippingRule, times(1)).applyRule(ruleInfoRequest(), ruleEntity());
    }
}
