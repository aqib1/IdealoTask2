package com.idealo.checkout.service;

import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.RuleResponse;

public interface CheckoutService {
    RuleResponse checkout(CheckoutRequest request);
}
