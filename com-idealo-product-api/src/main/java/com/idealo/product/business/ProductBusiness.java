package com.idealo.product.business;

import com.idealo.product.entities.ProductEntity;
import com.idealo.product.exceptions.InvalidProductException;
import com.idealo.product.exceptions.InvalidRequestException;
import com.idealo.product.mapper.ProductEntityMapper;
import com.idealo.product.model.*;
import com.idealo.product.services.Impl.ProductServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.List;
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

    public Mono<ResponseEntity<AddProductResponse>> addProduct(AddProductRequest request) {
        validateProductRequest(request);
        ProductEntity productEntity = service
                .save(mapper.productEntityFromAddProductRequest(request));
        AddProductResponse response = mapper
                .addProductResponseFromProductEntity(productEntity);
        response.detailMessage(saveSuccessDetailMessage);
        return Mono.just(ResponseEntity.ok(response));
    }

    public Mono<ResponseEntity<GetAllProductResponse>> getAll() {
        return Mono.just(ResponseEntity.ok(new GetAllProductResponse()
                .productDetailResponseList(mapper
                        .productDetailResponseListFromProductEntityList(service.getAll()))));
    }

    public Mono<ResponseEntity<GetProductBySkuResponse>> getAllBySku(GetProductBySkuRequest request) {
        validateGetProductBySkuRequest(request);
        return Mono.just(ResponseEntity.ok(new GetProductBySkuResponse()
                .productShortResponseList(mapper
                        .productShortResponseListFromProductEntityList(service
                                .getAllBySku(request.getSkuList())))));
    }

    private void validateProductRequest(AddProductRequest request) {
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

    private void validateGetProductBySkuRequest(GetProductBySkuRequest request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if (CollectionUtils.isEmpty(request.getSkuList())) {
            throw new InvalidRequestException("Request [skuList] cannot be null");
        }
    }
}
