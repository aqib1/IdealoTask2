package com.idealo.checkout.controller;

import com.idealo.checkout.business.ProductBusiness;
import com.idealo.checkout.model.AddProductResponse;
import com.idealo.checkout.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import static com.idealo.checkout.utils.AppConst.PRODUCT_API_URI;
/**
 * <p>
 * This is the class for idealo product controller
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
@RestController(PRODUCT_API_URI)
public class ProductController {

    @Autowired
    private ProductBusiness productBusiness;

    @PostMapping
    public Mono<ResponseEntity<AddProductResponse>> addProduct(ProductRequest request) {
     return null;
    }
}
