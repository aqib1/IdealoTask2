package com.idealo.pricing.rules.unit.business;

import com.idealo.pricing.rules.business.RuleBusiness;
import com.idealo.pricing.rules.exceptions.InvalidRequestException;
import com.idealo.pricing.rules.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static com.idealo.pricing.rules.utility.DataHelper.*;
import static com.idealo.pricing.rules.utility.DataHelper.dropRulesRequestForNullSkuList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RuleBusinessTest {
    @Mock
    private RuleBusiness ruleBusiness;

    @Test
    public void testPricingRules() {
        when(ruleBusiness.pricingRules(any(RuleRequest.class)))
                .thenReturn(ruleResponse());
        RuleResponse response = ruleBusiness.pricingRules(ruleRequest());
        assertEquals(response.getTotal(), 5l);
        assertEquals(response.getRuleInfoResponse(), ruleResponse().getRuleInfoResponse());
        verify(ruleBusiness, times(1)).pricingRules(ruleRequest());
    }

    @Test
    public void testPricingRulesWithNullRequest() {
        when(ruleBusiness.pricingRules(isNull())).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            ruleBusiness.pricingRules(null);
        });
        verify(ruleBusiness, times(1)).pricingRules(null);
    }

    @Test
    public void testPricingRulesWithEmptyRuleInfo() {
        when(ruleBusiness.pricingRules(ruleRequestWithNullRuleInfo()))
                .thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            ruleBusiness.pricingRules(ruleRequestWithNullRuleInfo());
        });
        verify(ruleBusiness, times(1)).pricingRules(ruleRequestWithNullRuleInfo());
    }

    @Test
    public void testAddRules() {
        when(ruleBusiness.addRules(any(AddRuleRequest.class)))
                .thenReturn(addRuleResponse());
        AddRuleResponse response = ruleBusiness.addRules(addRuleRequest());
        assertEquals(response, addRuleResponse());
        verify(ruleBusiness, times(1)).addRules(addRuleRequest());
    }

    @Test
    public void testAddRuleWithNullRequest() {
        when(ruleBusiness.addRules(isNull()))
                .thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            ruleBusiness.addRules(null);
        });
        verify(ruleBusiness, times(1)).addRules(null);
    }

    @Test
    public void testAddRuleWithEmptyRuleInfo() {
        when(ruleBusiness.addRules(addRuleRequestWithNullRuleInfos()))
                .thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            ruleBusiness.addRules(addRuleRequestWithNullRuleInfos());
        });
        verify(ruleBusiness, times(1)).addRules(addRuleRequestWithNullRuleInfos());
    }

    @Test
    public void testGetAll() {
        when(ruleBusiness.getAll()).thenReturn(getRulesResponse());
        GetRulesResponse getRulesResponse = ruleBusiness.getAll();
        assertEquals(getRulesResponse.getRuleInfos().size(), 1);
        assertEquals(getRulesResponse, getRulesResponse());
        verify(ruleBusiness, times(1)).getAll();
    }

    @Test
    public void testGetBySku() {
        when(ruleBusiness.getBySku(any(GetRulesBySkuRequest.class)))
                .thenReturn(getRulesResponse());
        GetRulesResponse getRulesResponse = ruleBusiness.getBySku(getRulesBySkuRequest());
        assertEquals(getRulesResponse.getRuleInfos().size(), 1);
        assertEquals(getRulesResponse, getRulesResponse());
        verify(ruleBusiness, times(1)).getBySku(getRulesBySkuRequest());
    }

    @Test
    public void testGetBySkuWithNullRequest() {
        when(ruleBusiness.getBySku(isNull())).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            ruleBusiness.getBySku(null);
        });
        verify(ruleBusiness, times(1)).getBySku(null);
    }

    @Test
    public void testGetBySkuWithSkuNull() {
        when(ruleBusiness.getBySku(getRulesBySkuRequestForNullSkuList())).thenThrow(new InvalidRequestException());
        assertThrows(InvalidRequestException.class, () -> {
            ruleBusiness.getBySku(getRulesBySkuRequestForNullSkuList());
        });
        verify(ruleBusiness, times(1)).getBySku(getRulesBySkuRequestForNullSkuList());
    }

    @Test
    public void testDropAll() {
        when(ruleBusiness.dropAll(any(DropRulesRequest.class)))
                .thenReturn(dropRulesResponse());
        DropRulesResponse response = ruleBusiness.dropAll(dropRulesRequest());
        assertEquals(response, dropRulesResponse());
        verify(ruleBusiness, times(1)).dropAll(dropRulesRequest());
    }

    @Test
    public void testDropAllWithNullRequest() {
        when(ruleBusiness.dropAll(isNull()))
                .thenThrow(new InvalidRequestException());

        assertThrows(InvalidRequestException.class, () -> {
            ruleBusiness.dropAll(null);
        });
        verify(ruleBusiness, times(1)).dropAll(null);
    }

    @Test
    public void testDropAllWithSkuList() {
        when(ruleBusiness.dropAll(dropRulesRequestForNullSkuList()))
                .thenThrow(new InvalidRequestException());

        assertThrows(InvalidRequestException.class, () -> {
            ruleBusiness.dropAll(dropRulesRequestForNullSkuList());
        });
        verify(ruleBusiness, times(1)).dropAll(dropRulesRequestForNullSkuList());
    }
}
