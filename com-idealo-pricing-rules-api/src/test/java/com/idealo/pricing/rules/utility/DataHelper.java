package com.idealo.pricing.rules.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.idealo.pricing.rules.data.RuleTypes;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.*;
import org.springframework.http.MediaType;

import java.util.List;

public class DataHelper {

    public static MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json");

    public static AddRuleResponse addRuleResponse() {
        return new AddRuleResponse().message("Rule added successfully");
    }

    public static RuleResponse ruleResponse() {
        return new RuleResponse().total(5L)
                .ruleInfoResponse(Lists.newArrayList(ruleInfoResponse()));
    }

    public static RuleInfoResponse ruleInfoResponse() {
        return new RuleInfoResponse().checkoutQuantity(1l)
                .sku("REXC").shipping(0L).unitPrice(5L)
                .specialPrice(5l);
    }

    public static List<String> skuList() {
        return Lists.newArrayList("REXC");
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

    public static List<RuleInfoRequest> ruleInfoRequestList() {
        return Lists.newArrayList(ruleInfoRequest());
    }

    public static RuleInfoRequest ruleInfoRequest() {
        return new RuleInfoRequest().checkoutQuantity(1l)
                .sku("REXC").shipping(0L).unitPrice(5L).unitPrice(5L);
    }

    public static List<RuleInfo> ruleInfoList() {
        return Lists.newArrayList(ruleInfo());
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

    public static List<RuleEntity> ruleEntityList() {
        return Lists.newArrayList(ruleEntity());
    }

    /**
     * Mock data for integration tests for pricing rule api
     */
    public static List<RuleEntity> getAllRuleEntities() {
        return Lists.newArrayList(
                new RuleEntity(1L, "REXC", 3L, 1L, RuleTypes.BNGN, true),
                new RuleEntity(2L, "AEXC", 4L, 50L, RuleTypes.PER, true),
                new RuleEntity(3L, "BEXC", 2L, 0L, RuleTypes.FSD, true)
        );
    }

    public static List<RuleEntity> getAllRuleEntitiesForDropApi() {
        return Lists.newArrayList(
                new RuleEntity(1L, "GGXC", 3L, 1L, RuleTypes.BNGN, true),
                new RuleEntity(2L, "PPXC", 4L, 50L, RuleTypes.PER, true),
                new RuleEntity(3L, "ZZXC", 2L, 0L, RuleTypes.FSD, true)
        );
    }

    public static List<RuleInfoRequest> getAllInfoRequest() {
        return Lists.newArrayList(
                new RuleInfoRequest().sku("REXC").unitPrice(50l).shipping(20l).checkoutQuantity(4l),
                new RuleInfoRequest().sku("AEXC").unitPrice(20l).shipping(5l).checkoutQuantity(5l),
                new RuleInfoRequest().sku("BEXC").unitPrice(10l).shipping(8l).checkoutQuantity(3l)
        );
    }

    public static GetRulesBySkuRequest getRulesBySkuRequestForGetBySku() {
        return new GetRulesBySkuRequest().skuList(
          Lists.newArrayList("REXC", "AEXC")
        );
    }

    public static RuleRequest ruleRequestForPricingRules() {
        return new RuleRequest().ruleInfoRequest(getAllInfoRequest());
    }

    public static AddRuleRequest ruleRequestForAddRules() {
        return new AddRuleRequest().ruleInfos(ruleInfoListForAddRules());
    }

    public static List<RuleInfo> ruleInfoListForAddRules() {
        return Lists.newArrayList(ruleInfoForAddRules());
    }

    public static RuleInfo ruleInfoForAddRules() {
        return new RuleInfo().ruleType("PER").discount(1L)
                .itemsFromApply(4l).sku("AZSE").isActive(true);
    }

    public static DropRulesRequest dropRulesRequestForDropAll() {
        return new DropRulesRequest().skuList(
                Lists.newArrayList("GGXC", "PPXC")
        );
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
