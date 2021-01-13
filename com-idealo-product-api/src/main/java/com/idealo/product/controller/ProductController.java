package com.idealo.product.controller;

import com.idealo.product.business.ProductBusiness;
import com.idealo.product.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.idealo.product.utils.AppConst.*;

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

    @PostMapping(PRODUCT_ADD)
    public Mono<ResponseEntity<AddProductResponse>> addProduct(@RequestBody AddProductRequest request) {
        return productBusiness.addProduct(request);
    }

    @GetMapping(PRODUCT_GET_ALL)
    public Mono<ResponseEntity<GetAllProductResponse>> getAll() {
        return productBusiness.getAll();
    }

    @PostMapping(PRODUCT_GET_ALL)
    public Mono<ResponseEntity<GetProductBySkuResponse>> getAllBySku(@RequestBody GetProductBySkuRequest request) {
        return productBusiness.getAllBySku(request);
    }

}
