package com.idealo.checkout.business;

import com.idealo.checkout.exception.InvalidRequestException;
import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.RuleResponse;
import com.idealo.checkout.service.Impl.CheckoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
    @Autowired
    private CheckoutServiceImpl service;

    public RuleResponse checkout(CheckoutRequest request) {
        validateCheckout(request);
        return  service.checkout(request);
    }

    private void validateCheckout(CheckoutRequest request) {
        if (Objects.isNull(request)) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if (CollectionUtils.isEmpty(request.getCheckoutInfo())) {
            throw new InvalidRequestException("Request [checkoutInfo] cannot be empty");
        }
    }
}
