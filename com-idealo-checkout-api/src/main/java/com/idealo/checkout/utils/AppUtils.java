package com.idealo.checkout.utils;

import com.idealo.checkout.model.CheckoutInfo;
import com.idealo.checkout.model.RuleInfoRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * This is the class for checkout application utilities
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
public class AppUtils {

    public static Map<String, CheckoutInfo> skuToCheckoutInfo(List<CheckoutInfo> values) {
        return values.stream().collect(Collectors.toMap(CheckoutInfo::getSku, info -> info));
    }

    public static Map<String, RuleInfoRequest> skuToRuleInfoRequest(List<RuleInfoRequest> ruleInfoRequests) {
        return ruleInfoRequests.stream().collect(Collectors.toMap(RuleInfoRequest::getSku, response -> response));
    }
}
