package com.idealo.checkout.service.Impl;

import com.idealo.checkout.entities.ProductEntity;
import com.idealo.checkout.model.AddProductResponse;
import com.idealo.checkout.repositories.ProductRepository;
import com.idealo.checkout.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return repository.save(productEntity);
    }
}
