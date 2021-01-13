package com.idealo.checkout.controller;

import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.CheckoutResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
@RestController(CHECKOUT_API_URI)
public class CheckoutController {

    @PostMapping(value = CHECKOUT_CHECK)
    public Mono<ResponseEntity<CheckoutResponse>> checkout(@RequestBody CheckoutRequest request){
        return null;
    }
}
