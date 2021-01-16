package com.idealo.checkout.clients;

import com.idealo.checkout.clients.fallbacks.RuleInfoFallBack;
import com.idealo.checkout.model.RuleRequest;
import com.idealo.checkout.model.RuleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import static com.idealo.checkout.utils.AppConst.PRICING_RULES_APPLY_URI;

@FeignClient(name = "${pricing.rules.api.baseurl}", fallbackFactory = RuleInfoFallBack.class)
public interface RuleInfoClient {
    @PostMapping(PRICING_RULES_APPLY_URI)
    RuleResponse pricingRules(RuleRequest request);
}
