package com.idealo.product.business;

import com.idealo.product.entities.ProductEntity;
import com.idealo.product.exceptions.InvalidProductException;
import com.idealo.product.exceptions.InvalidRequestException;
import com.idealo.product.exceptions.StockOutOfBoundException;
import com.idealo.product.mapper.ProductEntityMapper;
import com.idealo.product.model.*;
import com.idealo.product.services.Impl.ProductServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import static com.idealo.product.utils.AppUtils.skuByQuantity;
import static com.idealo.product.utils.AppUtils.skuByQuantityForCheckout;

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

    public AddProductResponse addProduct(AddProductRequest request) {
        validateProductRequest(request);
        ProductEntity productEntity = service
                .save(mapper.toProductEntity(request));
        return mapper
                .toAddProductResponse(productEntity)
                .detailMessage(saveSuccessDetailMessage);
    }

    public GetAllProductResponse getAll() {
        return new GetAllProductResponse()
                .productDetailResponseList(mapper
                        .toProductDetailResponseList(service.getAll()));
    }

    public GetProductBySkuResponse getAllBySku(CheckoutRequest request) {
        validateGetProductBySkuRequest(request);
        List<ProductShortResponse> productShortResponseList = mapper.toProductShortResponse(service
                .getAllBySku(request.getCheckoutInfo()
                        .stream().map(CheckoutInfo::getSku).collect(Collectors.toList())));
        verifyOutOfStockProducts(request.getCheckoutInfo(), productShortResponseList);
        return new GetProductBySkuResponse()
                .productShortResponseList(productShortResponseList);
    }

    public DropProductsResponse dropAll(DropProductsRequest request) {
        validateDropProductsRequest(request);
        service.dropAll(request.getSkuList());
        return new DropProductsResponse()
                .detailMessage("Products dropped successfully");
    }

    private void validateDropProductsRequest(DropProductsRequest request) {
        if(Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if(CollectionUtils.isEmpty(request.getSkuList())) {
            throw new InvalidRequestException("Request [sku] list cannot be empty or null");
        }
    }

    private void verifyOutOfStockProducts(List<CheckoutInfo> checkoutDetails, List<ProductShortResponse> productShortResponseList) {
        Map<String, Long> skuByQuantity = skuByQuantity(productShortResponseList);
        Map<String, Long> skuByQuantityForCheckout = skuByQuantityForCheckout(checkoutDetails);
        skuByQuantityForCheckout.keySet().stream().forEach(key -> {
            if (skuByQuantity.containsKey(key) && (skuByQuantity.get(key) < skuByQuantityForCheckout.get(key))) {
                throw new StockOutOfBoundException(
                        String.format("Stock for sku %s, have %d while requested %d",
                                key, skuByQuantity.get(key), skuByQuantityForCheckout.get(key)));
            }});
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

    private void validateGetProductBySkuRequest(CheckoutRequest request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if (CollectionUtils.isEmpty(request.getCheckoutInfo())) {
            throw new InvalidRequestException("Request [checkoutInfo] cannot be null");
        }
    }
}
