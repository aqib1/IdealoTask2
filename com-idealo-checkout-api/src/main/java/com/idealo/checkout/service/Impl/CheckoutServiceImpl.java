package com.idealo.checkout.service.Impl;

import com.google.common.collect.Lists;
import com.idealo.checkout.clients.ProductClient;
import com.idealo.checkout.clients.RuleInfoClient;
import com.idealo.checkout.mappers.RuleInfoMapper;
import com.idealo.checkout.model.*;
import com.idealo.checkout.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.idealo.checkout.utils.AppUtils.skuToCheckoutInfo;
import static com.idealo.checkout.utils.AppUtils.skuToRuleInfoRequest;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private RuleInfoClient ruleInfoClient;

    @Autowired
    private RuleInfoMapper mapper;

    @Override
    public RuleResponse checkout(CheckoutRequest request) {
        Map<String, RuleInfoRequest> skuToRuleInfoRequest = skuToRuleInfoRequest(mapper.toRuleInfoRequestList(
                getProductsBySku(request).getProductShortResponseList()
        ));
        updateCheckoutQuantity(skuToRuleInfoRequest, request);
        return requestPricing(new RuleRequest().ruleInfoRequest(
                Lists.newArrayList(skuToRuleInfoRequest.values())
        ));
    }

    private void updateCheckoutQuantity(Map<String, RuleInfoRequest> skuToRuleInfoRequest, CheckoutRequest request) {
        Map<String, CheckoutInfo> skuToCheckoutInfo = skuToCheckoutInfo(request.getCheckoutInfo());
        skuToCheckoutInfo.keySet().forEach(checkoutSku -> {
            if (skuToRuleInfoRequest.containsKey(checkoutSku)) {
                skuToRuleInfoRequest.get(checkoutSku).setCheckoutQuantity(
                        skuToCheckoutInfo.get(checkoutSku).getCheckoutQuantity());
            }
        });
    }

    private RuleResponse requestPricing(RuleRequest request) {
        return ruleInfoClient.pricingRules(request);
    }

    private GetProductBySkuResponse getProductsBySku(CheckoutRequest request) {
        return productClient.getAllBySku(request);
    }
}
