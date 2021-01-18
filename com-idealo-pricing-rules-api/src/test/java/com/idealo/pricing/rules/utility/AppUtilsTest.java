package com.idealo.pricing.rules.utility;

import com.google.common.collect.Sets;
import com.idealo.pricing.rules.entities.RuleEntity;
import com.idealo.pricing.rules.model.RuleInfoRequest;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.idealo.pricing.rules.utility.DataHelper.*;
import static com.idealo.pricing.rules.utils.AppUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUtilsTest {

    @Test
    public void testCalculatePercentage() {
        long result = calculatePercentage(100, 20);
        assertEquals(result, 20);
    }

    @Test
    public void testRuleInfoMapBySku() {
        Map<String, RuleInfoRequest> ruleInfoRequestBySku = ruleInfoMapBySku(ruleInfoRequestList());
        assertEquals(ruleInfoRequestBySku.keySet(), Sets.newHashSet("REXC"));
        assertEquals(ruleInfoRequestBySku.get("REXC"), ruleInfoRequest());
    }

    @Test
    public void testRuleEntityBySku() {
        Map<String, RuleEntity> ruleEntityBySku = ruleEntityBySku(ruleEntityList());
        assertEquals(ruleEntityBySku.keySet(), Sets.newHashSet("REXC"));
        assertEquals(ruleEntityBySku.get("REXC"), ruleEntity());
    }

    @Test
    public void testGetSkuListFromRuleInfo() {
        List<String> skuList = getSkuListFromRuleInfo(ruleInfoRequestList());
        assertEquals(skuList.size(), 1);
        assertEquals(skuList, Lists.newArrayList("REXC"));
    }
}
