package com.idealo.checkout.service;

import com.idealo.checkout.model.CheckoutRequest;
import com.idealo.checkout.model.CheckoutResponse;

import java.util.List;

public interface CheckoutService {
    CheckoutResponse checkout(CheckoutRequest request);
}
