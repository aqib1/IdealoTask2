package com.idealo.pricing.rules.data.Impl;

import com.idealo.pricing.rules.data.PricingRule;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfoRequest;
import static com.idealo.pricing.rules.utils.AppUtils.calculatePercentage;

public class PercentageRule implements PricingRule {

    @Override
    public Long applyRule(RuleInfoRequest request, RuleEntity entity) {
        long totalPriceByQuantity = request.getUnitPrice() * request.getCheckoutQuantity();
        return (request.getCheckoutQuantity() >= entity.getItemsFromApply() ?
                totalPriceByQuantity - calculatePercentage(request.getCheckoutQuantity() / entity.getItemsFromApply()
                        * request.getUnitPrice(), entity.getDiscount()) :
                totalPriceByQuantity) + request.getShipping();
    }
}
