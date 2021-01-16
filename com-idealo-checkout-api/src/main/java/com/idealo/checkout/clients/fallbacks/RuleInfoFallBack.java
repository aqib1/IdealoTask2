package com.idealo.checkout.clients.fallbacks;

import com.google.common.collect.Lists;
import com.idealo.checkout.clients.RuleInfoClient;
import com.idealo.checkout.model.RuleRequest;
import com.idealo.checkout.model.RuleResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RuleInfoFallBack implements FallbackFactory<RuleInfoClient> {

    @Value("${pricing.rules.api.baseurl}")
    private String pricingRulesApi;

    @Override
    public RuleInfoClient create(Throwable throwable) {
        return new RuleInfoClient() {
            @Override
            public RuleResponse pricingRules(RuleRequest request) {
                return new RuleResponse().total(0l)
                        .ruleInfoResponse(Lists.newArrayList());
            }
        };
    }
}
