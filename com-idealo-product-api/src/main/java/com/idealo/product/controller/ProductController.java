package com.idealo.product.controller;

import com.idealo.product.business.ProductBusiness;
import com.idealo.product.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody AddProductRequest request) {
        return ResponseEntity.ok(productBusiness.addProduct(request));
    }

    @GetMapping(PRODUCT_GET_ALL)
    public ResponseEntity<GetAllProductResponse> getAll() {
        return ResponseEntity.ok(productBusiness.getAll());
    }

    @PostMapping(PRODUCT_GET_ALL)
    public ResponseEntity<GetProductBySkuResponse> getAllBySku(@RequestBody CheckoutRequest request) {
        return ResponseEntity.ok(productBusiness.getAllBySku(request));
    }


    @PostMapping(PRODUCT_DROP_ALL)
    public ResponseEntity<DropProductsResponse> dropAll(@RequestBody DropProductsRequest request) {
        return ResponseEntity.ok(productBusiness.dropAll(request));
    }

}
