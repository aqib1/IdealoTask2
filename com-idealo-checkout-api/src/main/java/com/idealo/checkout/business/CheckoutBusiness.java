package com.idealo.checkout.business;

import com.idealo.checkout.exceptions.InvalidRequestException;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.CheckoutResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Mono;

import java.util.Objects;
/**
 * <p>
 * This is the class for idealo checkout business
 * </p>
 *
 * @author Aqib
 * @version 0.0.1
 * @since 01/13/2021
 */

@Component
public class CheckoutBusiness {

    public Mono<ResponseEntity<CheckoutResponse>> checkout(CheckoutRequest request){
        validateCheckout(request);
        return null;
    }

    private void validateCheckout(CheckoutRequest request) {
        if(Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if(CollectionUtils.isEmpty(request.getSkuList())) {
            throw new InvalidRequestException("Request [sku-list] cannot be null");
        }
    }
}
