package com.idealo.checkout.service;

import com.idealo.checkout.entities.ProductEntity;
import com.idealo.checkout.model.AddProductResponse;

public interface ProductService {
    ProductEntity save(ProductEntity productEntity);
}
