package com.idealo.pricing.rules.unit.data.Impl;

import com.idealo.pricing.rules.data.Impl.BNGNRule;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfoRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.pricing.rules.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BNGNRuleTest {

    @Mock
    private BNGNRule bngnRule;

    @Test
    public void testApplyRule() {
        when(bngnRule.applyRule(any(RuleInfoRequest.class),any(RuleEntity.class)))
                .thenReturn(100L);

        assertEquals(bngnRule.applyRule(ruleInfoRequest(), ruleEntity()), 100L);
        verify(bngnRule, times(1)).applyRule(ruleInfoRequest(), ruleEntity());
    }
}
