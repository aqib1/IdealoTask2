package com.idealo.pricing.rules.controller;

import com.idealo.pricing.rules.business.RuleBusiness;
import com.idealo.pricing.rules.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.idealo.pricing.rules.utils.AppConst.*;

@RestController
@RequestMapping(PRICING_API_URL)
public class RuleController {

    @Autowired
    private RuleBusiness business;

    @PostMapping(PRICING_RULE_API_URL)
    public ResponseEntity<RuleResponse> pricingRules(@RequestBody RuleRequest request) {
        return ResponseEntity.ok(business.pricingRules(request));
    }

    @PostMapping(PRICING_RULE_ADD_API_URL)
    public ResponseEntity<AddRuleResponse> addRules(@RequestBody AddRuleRequest request) {
        return ResponseEntity.ok(business.addRules(request));
    }

    @GetMapping(PRICING_RULE_GET_ALL_URL)
    public ResponseEntity<GetRulesResponse> getAll() {
        return ResponseEntity.ok(business.getAll());
    }

    @PostMapping(PRICING_RULE_GET_ALL_URL)
    public ResponseEntity<GetRulesResponse> getBySku(@RequestBody GetRulesBySkuRequest request) {
        return ResponseEntity.ok(business.getBySku(request));
    }

    @PostMapping(PRICING_RULE_DROP_ALL_URL)
    public ResponseEntity<DropRulesResponse> dropAll(@RequestBody DropRulesRequest request) {
        return ResponseEntity.ok(business.dropAll(request));
    }

}
