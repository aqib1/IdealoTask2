package com.idealo.pricing.rules.unit.mapper;

import com.idealo.pricing.rules.mapper.RuleInfoMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.pricing.rules.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RuleInfoMapperTest {
    @Mock
    private RuleInfoMapper mapper;

    @Test
    public void testToRuleInfo() {
        when(mapper.toRuleInfo(ruleEntity())).thenReturn(ruleInfo());
        assertEquals(mapper.toRuleInfo(ruleEntity()), ruleInfo());
        verify(mapper, times(1)).toRuleInfo(ruleEntity());
    }

    @Test
    public void testToRuleList() {
        when(mapper.toRuleInfoList(ruleEntityList())).thenReturn(ruleInfoList());
        assertEquals(mapper.toRuleInfoList(ruleEntityList()), ruleInfoList());
        verify(mapper, times(1)).toRuleInfoList(ruleEntityList());
    }
}
