package com.idealo.checkout.service.Impl;

import com.google.common.collect.Lists;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.CheckoutResponse;
import com.idealo.checkout.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.idealo.checkout.utils.AppUtils.listToMapByCount;

public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private WebClient.Builder webClient;

    @Override
    public CheckoutResponse checkout(CheckoutRequest request) {
      Map<String, Long> skuByCount = listToMapByCount(request.getSkuList());
      // For non repeated values
      request.setSkuList(Lists.newArrayList(skuByCount.keySet()));
      getAllProductsBySku(request);
      return null;
    }

    private void getAllProductsBySku(CheckoutRequest request) {

    }
}
