package com.idealo.pricing.rules.unit.mapper;

import com.idealo.pricing.rules.mapper.RuleInfoResponseMapper;
import com.idealo.pricing.rules.model.RuleInfoRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.pricing.rules.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RuleInfoResponseMapperTest {

    @Mock
    private RuleInfoResponseMapper mapper;

    @Test
    public void testToRuleInfoResponse() {
        when(mapper.toRuleInfoResponse(any(RuleInfoRequest.class)))
                .thenReturn(ruleInfoResponse());
        assertEquals(mapper.toRuleInfoResponse(ruleInfoRequest()), ruleInfoResponse());
        verify(mapper, times(1)).toRuleInfoResponse(ruleInfoRequest());
    }
}
