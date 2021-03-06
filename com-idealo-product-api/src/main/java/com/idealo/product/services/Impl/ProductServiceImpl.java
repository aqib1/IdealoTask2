package com.idealo.product.services.Impl;

import com.idealo.product.entities.ProductEntity;
import com.idealo.product.repositories.ProductRepository;
import com.idealo.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.idealo.product.repositories.specifications.ProductSpecifications.bySkuSpecification;
import static com.idealo.product.repositories.specifications.ProductSpecifications.isActiveSpecification;

/**
 * <p>
 * This is the class for product service implementation
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return repository.save(productEntity);
    }

    @Override
    public List<ProductEntity> getAll() {
        return repository.findAll(isActiveSpecification());
    }

    @Override
    public List<ProductEntity> getAllBySku(List<String> skuList) {
        return repository.findAll(bySkuSpecification(skuList));
    }

    @Override
    public void dropAll(List<String> skuList) {
        repository.dropAll(skuList);
    }
}
