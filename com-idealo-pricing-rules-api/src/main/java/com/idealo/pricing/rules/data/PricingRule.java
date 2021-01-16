package com.idealo.pricing.rules.data;

import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfoRequest;

public interface PricingRule {
    Long applyRule(RuleInfoRequest request, RuleEntity entity);
}
