package com.idealo.checkout.utility;

import com.google.common.collect.Lists;
import com.idealo.checkout.model.CheckoutInfo;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.RuleInfoResponse;
import com.idealo.checkout.model.RuleResponse;

import java.util.List;

public class DataHelper {

    public static RuleResponse ruleResponse() {
        return new RuleResponse().ruleInfoResponse(ruleInfoResponseList());
    }

    public static List<RuleInfoResponse> ruleInfoResponseList() {
        return Lists.newArrayList(ruleInfoResponse());
    }

    public static RuleInfoResponse ruleInfoResponse() {
        return new RuleInfoResponse()
                .checkoutQuantity(1l)
                .sku("ERAC")
                .shipping(0L)
                .unitPrice(5L)
                .specialPrice(5l);
    }

    public static CheckoutRequest checkoutRequest() {
        return new CheckoutRequest().checkoutInfo(checkoutInfoList());
    }

    public static List<CheckoutInfo> checkoutInfoList() {
        return Lists.newArrayList(checkoutInfo());
    }

    public static CheckoutInfo checkoutInfo() {
        return new CheckoutInfo()
                .checkoutQuantity(1l)
                .sku("ERAC");
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
