package com.idealo.pricing.rules.data.Impl;

import com.idealo.pricing.rules.data.PricingRule;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfoRequest;

public class NoRule implements PricingRule {

    @Override
    public Long applyRule(RuleInfoRequest request, RuleEntity entity) {
        return (request.getUnitPrice() * request.getCheckoutQuantity())
                + request.getShipping();
    }
}
