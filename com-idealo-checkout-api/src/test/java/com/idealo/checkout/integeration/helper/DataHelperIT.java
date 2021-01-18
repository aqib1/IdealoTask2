package com.idealo.checkout.integeration.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.idealo.checkout.model.*;
import org.springframework.http.MediaType;

public class DataHelperIT {

    public static MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json");

    public static CheckoutRequest checkoutRequest() {
        return new CheckoutRequest().checkoutInfo(Lists.newArrayList(new CheckoutInfo().checkoutQuantity(6l).sku("SKU")));
    }

    public static CheckoutRequest invalidCheckoutRequest() {
        return new CheckoutRequest();
    }

    public static GetProductBySkuResponse getProductBySkuResponse() {
        return new GetProductBySkuResponse().productShortResponseList(
                Lists.newArrayList(
                        new ProductShortResponse()
                                .productId("Test Prod 1")
                                .sku("SKU")
                                .shipping(5l)
                                .unitPrice(50l)
                                .quantity(10l)
                                .detailedMessage(""))
        );
    }

    public static RuleResponse ruleResponse() {
        return new RuleResponse().total(300l).ruleInfoResponse(
                Lists.newArrayList(
                        new RuleInfoResponse()
                                .shipping(5l)
                                .specialPrice(300l)
                                .sku("SKU")
                                .checkoutQuantity(6l)
                                .unitPrice(50l)
                                .detailedMessage("Free shipping for buying 5 items")
                )
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
        private static final DataHelperIT INSTANCE = new DataHelperIT();

        private InstanceHolder() {

        }
    }


    public static DataHelperIT getInstance() {
        return DataHelperIT.InstanceHolder.INSTANCE;
    }

    private DataHelperIT() {

    }
}
