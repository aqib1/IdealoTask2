package com.idealo.pricing.rules.unit.mapper;

import com.idealo.pricing.rules.mapper.RuleEntityMapper;
import com.idealo.pricing.rules.model.RuleInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.pricing.rules.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RuleEntityMapperTest {

    @Mock
    private RuleEntityMapper mapper;

    @Test
    public void testToRuleEntity() {
        when(mapper.toRuleEntity(any(RuleInfo.class)))
                .thenReturn(ruleEntity());
        assertEquals(mapper.toRuleEntity(ruleInfo()), ruleEntity());
        verify(mapper, times(1)).toRuleEntity(ruleInfo());
    }

    @Test
    public void testToRuleEntityList() {
        when(mapper.toRuleEntityList(anyList()))
                .thenReturn(ruleEntityList());
        assertEquals(mapper.toRuleEntityList(ruleInfoList()), ruleEntityList());
        verify(mapper, times(1)).toRuleEntityList(ruleInfoList());
    }

}
