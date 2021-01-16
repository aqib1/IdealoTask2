package com.idealo.pricing.rules.utils;

import com.google.common.collect.Lists;
import com.idealo.pricing.rules.data.RuleTypes;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfoRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppUtils {

    private AppUtils() {

    }

    public static long calculatePercentage(long price, long percent) {
        return Math.round((double) percent * price / 100);
    }

    public static Map<String, RuleInfoRequest> ruleInfoMapBySku(List<RuleInfoRequest> pricingRuleRequests) {
        return pricingRuleRequests.stream().collect(Collectors.toMap(RuleInfoRequest::getSku, request -> request));
    }

    public static Map<String, RuleEntity> ruleEntityBySku(List<RuleEntity> ruleEntities) {
        return ruleEntities.stream().collect(Collectors.toMap(RuleEntity::getSku, entity -> entity));
    }

    public static List<String> getSkuListFromRuleInfo(List<RuleInfoRequest> ruleInfoRequests) {
        return ruleInfoRequests.stream().map(RuleInfoRequest::getSku).collect(Collectors.toList());
    }

    public static List<RuleEntity> getInitRules() {
        return Lists.newArrayList(
                new RuleEntity(1L, "PKCAQ", 3l, 1l, RuleTypes.BNGN, true),
                new RuleEntity(2L, "PKCAB", 10l, 2l, RuleTypes.BNGN, true),
                new RuleEntity(3L, "ABlAQ", 4l, 0l, RuleTypes.FSD, true),
                new RuleEntity(4L, "ABlAB", 6l, 0l, RuleTypes.FSD, true),
                new RuleEntity(5L, "ZKNMQ", 5l, 50l, RuleTypes.PER, true),
                new RuleEntity(6L, "XKNMQ", 3l, 30l, RuleTypes.PER, true)
        );
    }
}
