package com.idealo.checkout.utility;

import com.idealo.checkout.model.CheckoutInfo;
import com.idealo.checkout.model.RuleInfoRequest;
import com.idealo.checkout.utils.AppUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.idealo.checkout.utility.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUtilsTest {

    @Test
    public void SkuToCheckoutInfoTest() {
        Map<String, CheckoutInfo> skuToCheckoutInfo = AppUtils.skuToCheckoutInfo(checkoutInfoList());
        assertEquals(skuToCheckoutInfo.get("ERAC"), checkoutInfo());
    }

    @Test
    public void testSkuToRuleInfoRequest() {
        Map<String, RuleInfoRequest> skuToCheckoutInfo = AppUtils.skuToRuleInfoRequest(getRuleInfoRequestList());
        assertEquals(skuToCheckoutInfo.get("ERAC"), ruleInfoRequest());
    }

}
