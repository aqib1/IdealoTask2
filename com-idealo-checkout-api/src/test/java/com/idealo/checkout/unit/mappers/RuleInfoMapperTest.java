package com.idealo.checkout.unit.mappers;

import com.idealo.checkout.mappers.RuleInfoMapper;
import com.idealo.checkout.model.ProductShortResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.checkout.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RuleInfoMapperTest {

    @Mock
    private RuleInfoMapper mapper;

    @Test
    public void testToRuleInfoRequest() {
        when(mapper.toRuleInfoRequest(any(ProductShortResponse.class)))
                .thenReturn(ruleInfoRequest());
        assertEquals(mapper.toRuleInfoRequest(productShortResponse()), ruleInfoRequest());
        verify(mapper, times(1)).toRuleInfoRequest(productShortResponse());
    }

    @Test
    public void toRuleInfoRequestList() {
        when(mapper.toRuleInfoRequestList(anyList()))
                .thenReturn(getRuleInfoRequestList());
        assertEquals(mapper.toRuleInfoRequestList(productShortResponseList()), getRuleInfoRequestList());
        verify(mapper, times(1)).toRuleInfoRequestList(productShortResponseList());
    }
}

