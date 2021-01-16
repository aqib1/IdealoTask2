package com.idealo.checkout.clients;

import com.idealo.checkout.clients.fallbacks.ProductClientFallBack;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.GetProductBySkuResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import static com.idealo.checkout.utils.AppConst.PRODUCT_GET_ALL;

@FeignClient(name = "${product.api.baseurl}", fallbackFactory = ProductClientFallBack.class)
public interface ProductClient {

    @PostMapping(PRODUCT_GET_ALL)
    GetProductBySkuResponse getAllBySku(CheckoutRequest request);

}
