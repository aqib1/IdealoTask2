package com.idealo.product.business;

import com.idealo.product.entities.ProductEntity;
import com.idealo.product.exceptions.InvalidProductException;
import com.idealo.product.exceptions.InvalidRequestException;
import com.idealo.product.mapper.ProductEntityMapper;
import com.idealo.product.model.AddProductResponse;
import com.idealo.product.model.ProductRequest;
import com.idealo.product.services.Impl.ProductServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * <p>
 * This is the class for idealo product business
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */

@Component
public class ProductBusiness {

    @Autowired
    private ProductEntityMapper mapper;

    @Autowired
    private ProductServiceImpl service;

    @Value("${product.save.success.detail.message}")
    private String saveSuccessDetailMessage;

    public Mono<ResponseEntity<AddProductResponse>> addProduct(ProductRequest request) {
        validateProductRequest(request);
        ProductEntity productEntity = service.save(mapper.productEntityFromProductRequest(request));
        AddProductResponse response = mapper.addProductResponseFromProductEntity(productEntity);
        response.detailMessage(saveSuccessDetailMessage);
        return Mono.just(ResponseEntity.ok(response));
    }

    private void validateProductRequest(ProductRequest request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if (StringUtils.isBlank(request.getSku())) {
            throw new InvalidProductException("Request [sku] cannot be empty or null");
        }
        if (StringUtils.isBlank(request.getProductId())) {
            throw new InvalidProductException("Request [product-id] cannot be empty or null");
        }
        if (StringUtils.isBlank(request.getProductName())) {
            throw new InvalidProductException("Request [product-name] cannot be empty or null");
        }
        if (request.getUnitPrice() == 0) {
            throw new InvalidProductException("Request [unit-price] cannot be 0 for a product");
        }
        if (request.getQuantity() == 0) {
            throw new InvalidProductException("Request [quantity] cannot be 0 for a product");
        }
    }
}
