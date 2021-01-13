package com.idealo.checkout.business;
import com.idealo.checkout.exceptions.InvalidProductException;
import com.idealo.checkout.exceptions.InvalidRequestException;
import com.idealo.checkout.model.AddProductResponse;
import com.idealo.checkout.model.ProductRequest;
import org.apache.commons.lang3.StringUtils;
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

    public Mono<ResponseEntity<AddProductResponse>> addProduct(ProductRequest request) {
        validateProductRequest(request);
        return null;
    }

    private void validateProductRequest(ProductRequest request) {
        if(Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if(StringUtils.isBlank(request.getSKU())) {
            throw new InvalidProductException("Request [SKU] cannot be empty or null");
        }
        if(StringUtils.isBlank(request.getProductId())) {
            throw new InvalidProductException("Request [product-id] cannot be empty or null");
        }
        if(StringUtils.isBlank(request.getProductName())) {
            throw new InvalidProductException("Request [product-name] cannot be empty or null");
        }
        if(request.getUnitPrice() == 0) {
            throw new InvalidProductException("Request [unit-price] cannot be 0 for a product");
        }
        if(request.getQuantity() == 0) {
            throw new InvalidProductException("Request [quantity] cannot be 0 for a product");
        }
    }
}
