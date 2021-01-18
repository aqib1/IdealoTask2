package com.idealo.pricing.rules.unit.data.Impl;

import com.idealo.pricing.rules.data.Impl.PercentageRule;
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
public class PercentageRuleTest {
    @Mock
    private PercentageRule percentageRule;

    @Test
    public void testApplyRule() {
        when(percentageRule.applyRule(any(RuleInfoRequest.class),any(RuleEntity.class)))
                .thenReturn(10L);

        assertEquals(percentageRule.applyRule(ruleInfoRequest(), ruleEntity()), 10L);
        verify(percentageRule, times(1)).applyRule(ruleInfoRequest(), ruleEntity());
    }
}
