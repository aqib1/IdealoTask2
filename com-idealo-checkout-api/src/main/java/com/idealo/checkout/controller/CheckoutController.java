package com.idealo.checkout.controller;

import com.idealo.checkout.business.CheckoutBusiness;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.RuleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.idealo.checkout.utils.AppConst.CHECKOUT_API_URI;
import static com.idealo.checkout.utils.AppConst.CHECKOUT_CHECK;

/**
 * <p>
 * This is the class for idealo checkout controller
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */
@RestController
@RequestMapping(CHECKOUT_API_URI)
public class CheckoutController {
    @Autowired
    private CheckoutBusiness checkoutBusiness;

    @PostMapping(CHECKOUT_CHECK)
    public ResponseEntity<RuleResponse> checkout(@RequestBody CheckoutRequest request) {
        return ResponseEntity.ok(checkoutBusiness.checkout(request));
    }
}
