package com.idealo.pricing.rules.data;

import com.idealo.pricing.rules.data.Impl.BNGNRule;
import com.idealo.pricing.rules.data.Impl.FreeShippingRule;
import com.idealo.pricing.rules.data.Impl.NoRule;
import com.idealo.pricing.rules.data.Impl.PercentageRule;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum RuleTypes {
    BNGN("BN", "Product %s have offer to buy %d products get %d products free", new BNGNRule()), // Buy N get N free (we can use that for buy one get one free discount)
    PER("PR", "Product %s have offer to buy %d products get %d % discount", new PercentageRule()), // PER is percentage discount
    FSD("FS","Product %s have offer to buy %d products get free shipment", new FreeShippingRule()), // Free shipping discount
    NO("N", "Product %s have no offer at the moment" ,new NoRule()); // If no rule is found
    private String tag;
    private String detail;
    private PricingRule pricingRule;

    private RuleTypes(String tag, String detail , PricingRule pricingRule) {
        this.tag = tag;
        this.detail = detail;
        this.pricingRule = pricingRule;
    }

    public String getDetails(String sku, Long buy, Long free) {
        return String.format(detail, sku, buy, free);
    }
}
