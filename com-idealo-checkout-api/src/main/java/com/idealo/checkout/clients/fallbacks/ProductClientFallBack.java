package com.idealo.checkout.clients.fallbacks;

import com.google.common.collect.Lists;
import com.idealo.checkout.clients.ProductClient;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.GetProductBySkuResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFallBack implements FallbackFactory<ProductClient> {

    @Value("${product.api.baseurl}")
    private String productApi;

    @Override
    public ProductClient create(Throwable throwable) {
        return new ProductClient() {
            @Override
            public GetProductBySkuResponse getAllBySku(CheckoutRequest request) {
                return new GetProductBySkuResponse()
                        .productShortResponseList(Lists.newArrayList());
            }
        };
    }
}