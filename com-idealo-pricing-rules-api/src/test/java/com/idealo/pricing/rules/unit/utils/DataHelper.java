package com.idealo.pricing.rules.unit.utils;

import com.google.common.collect.Lists;
import com.idealo.pricing.rules.data.RuleTypes;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.*;

public class DataHelper {

    public static AddRuleResponse addRuleResponse() {
        return new AddRuleResponse().message("Rule added successfully");
    }

    public static RuleResponse ruleResponse() {
        return new RuleResponse().total(5L)
                .ruleInfoResponse(Lists.newArrayList(
                        new RuleInfoResponse().checkoutQuantity(1l)
                                .sku("REXC").shipping(0L).unitPrice(5L)
                                .specialPrice(5l)));
    }

    public static AddRuleRequest addRuleRequestWithNullRuleInfos() {
        return new AddRuleRequest().ruleInfos(null);
    }
    public static AddRuleRequest addRuleRequest() {
        return new AddRuleRequest().ruleInfos(Lists.newArrayList(ruleInfo()));
    }

    public static RuleRequest ruleRequest() {
        return new RuleRequest().ruleInfoRequest(Lists.newArrayList(ruleInfoRequest()));
    }

    public static RuleRequest ruleRequestWithNullRuleInfo() {
        return new RuleRequest().ruleInfoRequest(null);
    }

    public static RuleInfoRequest ruleInfoRequest() {
        return new RuleInfoRequest().checkoutQuantity(1l)
                .sku("REXC").shipping(0L).unitPrice(5L).unitPrice(5L);
    }

    public static RuleInfo ruleInfo() {
        return new RuleInfo().ruleType("BNGN").discount(1L)
                .itemsFromApply(4l).sku("REXC").isActive(true);
    }

    public static GetRulesResponse getRulesResponse() {
        return new GetRulesResponse().ruleInfos(Lists.newArrayList(ruleInfo()));
    }

    public static GetRulesBySkuRequest getRulesBySkuRequest() {
        return new GetRulesBySkuRequest().skuList(Lists.newArrayList("REXC"));
    }

    public static GetRulesBySkuRequest getRulesBySkuRequestForNullSkuList() {
        return new GetRulesBySkuRequest().skuList(null);
    }

    public static DropRulesRequest dropRulesRequestForNullSkuList() {
        return new DropRulesRequest().skuList(null);
    }

    public static DropRulesRequest dropRulesRequest() {
        return new DropRulesRequest().skuList(Lists.newArrayList("REXC"));
    }

    public static DropRulesResponse dropRulesResponse() {
        return new DropRulesResponse().detailMessage("Rule dropped successfully");
    }

    public static RuleEntity ruleEntity() {
        return new RuleEntity(1L, "REXC", 3L, 1L, RuleTypes.BNGN, true);
    }

    /**
     * Initialization on demand pattern
     * this pattern is alternative of double check locking pattern
     * which not even support lazy loading but also safe to use in
     * multi-processor distributed instances
     */
    private static class InstanceHolder {
        private static final DataHelper INSTANCE = new DataHelper();

        private InstanceHolder() {

        }
    }


    public static DataHelper getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private DataHelper() {

    }
}
