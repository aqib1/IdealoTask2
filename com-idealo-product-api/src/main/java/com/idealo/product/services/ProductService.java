package com.idealo.product.services;

import com.idealo.product.entities.ProductEntity;
import java.util.List;

/**
 * <p>
 * This is the class for product service
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
public interface ProductService {
    ProductEntity save(ProductEntity productEntity);

    List<ProductEntity> getAll();

    List<ProductEntity> getAllBySku(List<String> skuList);

    void dropAll(List<String> skuList);
}
