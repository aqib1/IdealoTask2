package com.idealo.product.controller;

import com.idealo.product.business.ProductBusiness;
import com.idealo.product.model.AddProductResponse;
import com.idealo.product.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.idealo.product.utils.AppConst.PRODUCT_API_URI;

/**
 * <p>
 * This is the class for idealo product controller
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
@RestController
@RequestMapping(PRODUCT_API_URI)
public class ProductController {

    @Autowired
    private ProductBusiness productBusiness;

    @PostMapping
    public Mono<ResponseEntity<AddProductResponse>> addProduct(@RequestBody ProductRequest request) {
     return productBusiness.addProduct(request);
    }
}
