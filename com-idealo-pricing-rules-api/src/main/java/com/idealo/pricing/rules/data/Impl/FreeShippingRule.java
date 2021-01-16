package com.idealo.pricing.rules.data.Impl;

import com.idealo.pricing.rules.data.PricingRule;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfoRequest;

public class FreeShippingRule implements PricingRule {

    @Override
    public Long applyRule(RuleInfoRequest request, RuleEntity entity) {
        long totalPriceByQuantity = request.getUnitPrice() * request.getCheckoutQuantity();
        return (request.getCheckoutQuantity() >= entity.getItemsFromApply()) ?
                totalPriceByQuantity : totalPriceByQuantity + request.getShipping();
    }
}
