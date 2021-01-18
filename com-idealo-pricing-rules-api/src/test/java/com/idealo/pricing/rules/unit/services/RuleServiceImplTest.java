package com.idealo.pricing.rules.unit.services;

import com.idealo.pricing.rules.model.RuleRequest;
import com.idealo.pricing.rules.services.Impl.RuleServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.pricing.rules.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RuleServiceImplTest {

    @Mock
    private RuleServiceImpl service;

    @Test
    public void testPricingRules() {
        when(service.pricingRules(any(RuleRequest.class))).thenReturn(ruleResponse());
        assertEquals(service.pricingRules(ruleRequest()), ruleResponse());
        verify(service, times(1)).pricingRules(ruleRequest());
    }

    @Test
    public void testAddRules() {
        when(service.addRules(ruleEntityList())).thenReturn(ruleEntityList());
        assertEquals(service.addRules(ruleEntityList()), ruleEntityList());
        verify(service, times(1)).addRules(ruleEntityList());
    }

    @Test
    public void testGetAll() {
        when(service.getAll()).thenReturn(ruleEntityList());
        assertEquals(service.getAll(), ruleEntityList());
        verify(service, times(1)).getAll();
    }

    @Test
    public void testDropAll() {
        doNothing().when(service).dropAll(skuList());
        service.dropAll(skuList());
        verify(service, times(1)).dropAll(skuList());
    }
}
