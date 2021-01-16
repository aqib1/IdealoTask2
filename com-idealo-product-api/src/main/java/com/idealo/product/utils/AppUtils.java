package com.idealo.product.utils;

import com.google.common.collect.Lists;
import com.idealo.product.entities.ProductEntity;
import com.idealo.product.model.CheckoutInfo;
import com.idealo.product.model.ProductShortResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppUtils {

    private AppUtils() {

    }

    public static Map<String, Long> skuByQuantity(List<ProductShortResponse> productShortResponses) {
        return productShortResponses.stream().collect(Collectors.toMap(ProductShortResponse::getSku, ProductShortResponse::getQuantity));
    }

    public static Map<String, Long> skuByQuantityForCheckout(List<CheckoutInfo> checkoutDetails) {
        return checkoutDetails.stream().collect(Collectors.toMap(CheckoutInfo::getSku, CheckoutInfo::getCheckoutQuantity));
    }

    public static List<ProductEntity> getInitProducts() {
        return Lists.newArrayList(
                new ProductEntity(1l, "PKCAQ", "COBB-S1", "Cobblestone","USA", "Landford", 500l, 100l, 50l, "Paster Stanley", true),
                new ProductEntity(2l, "PKCAB", "AL-E3", "Alpro","Hungary", "Budweiser", 50l, 500l, 0l, "Budweiser Co", true),
                new ProductEntity(3l, "ABlAQ", "KD-I6", "Kinder","U.K", "Ferrero SPA", 10l, 5000l, 0l, "James Ben", true),
                new ProductEntity(4l, "ABlAB", "TK-K4", "Tastykake","Poland", "Tasty Baking", 200l, 1200l, 50l, "James Ben", true),
                new ProductEntity(5l, "ZKNMQ", "CC-S2", "Cheery Cakes","France", "Baskin Robbins", 300l, 200l, 30l, "Csaba Nagy", true),
                new ProductEntity(6l, "XKNMQ", "MA-P8", "Maypo","China", "Maltex Co", 30l, 180l, 5l, "Chen li", true)
        );
    }
}
