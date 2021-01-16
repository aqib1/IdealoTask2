package com.idealo.pricing.rules.unit.controller;

import com.idealo.pricing.rules.controller.RuleController;
import com.idealo.pricing.rules.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.idealo.pricing.rules.unit.utils.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RuleControllerTest {

    @Mock
    private RuleController ruleController;

    @Test
    public void testPricingRules() {
        when(ruleController.pricingRules(any(RuleRequest.class))).thenReturn(
                ResponseEntity.ok(ruleResponse()));

        ResponseEntity<RuleResponse> response = ruleController.pricingRules(ruleRequest());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), ruleResponse());
    }

    @Test
    public void testAddRules() {
        when(ruleController.addRules(any(AddRuleRequest.class))).thenReturn(
                ResponseEntity.ok(addRuleResponse()));
        ResponseEntity<AddRuleResponse> response = ruleController.addRules(addRuleRequest());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), addRuleResponse());
    }

    @Test
    public void testGetAll() {
        when(ruleController.getAll()).thenReturn(ResponseEntity.ok(getRulesResponse()));
        ResponseEntity<GetRulesResponse> response = ruleController.getAll();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), getRulesResponse());
    }

    @Test
    public void testGetBySku() {
        when(ruleController.getBySku(any(GetRulesBySkuRequest.class))).thenReturn(
                ResponseEntity.ok(getRulesResponse()));
        ResponseEntity<GetRulesResponse> response = ruleController.getBySku(getRulesBySkuRequest());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), getRulesResponse());
    }

    @Test
    public void  testDropAll() {
        when(ruleController.dropAll(any(DropRulesRequest.class))).thenReturn(
                ResponseEntity.ok(dropRulesResponse()));
        ResponseEntity<DropRulesResponse> response = ruleController.dropAll(dropRulesRequest());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), dropRulesResponse());
    }

}
