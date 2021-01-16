package com.idealo.pricing.rules.services;

import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfo;
import com.idealo.pricing.rules.model.RuleRequest;
import com.idealo.pricing.rules.model.RuleResponse;

import java.util.List;

public interface RuleService {
    RuleResponse pricingRules(RuleRequest request);
    List<RuleEntity> addRules(List<RuleEntity> ruleEntities);
    List<RuleEntity> getAll();
    List<RuleEntity> getAll(List<String> skuList);
    void dropAll(List<String> skuList);
}
